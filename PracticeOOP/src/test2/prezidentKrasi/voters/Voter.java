package test2.prezidentKrasi.voters;

import test2.prezidentKrasi.Ballot;
import test2.prezidentKrasi.CIK;
import test2.prezidentKrasi.candidates.Candidate;

import java.util.Random;

public abstract class Voter {

    public enum Gender {MALE, FEMALE}

    public static test2.prezidentKrasi.CIK CIK;
    private String name;
    private Gender gender;
    private String city;
    private Candidate candidate;
    private boolean isBought;
    private boolean wentToVote;

    public Voter(String name, Gender gender, String city, Candidate candidate, boolean isBought) {
        this.name = name;
        this.gender = gender;
        this.city = city;
        this.candidate = candidate;
        this.isBought = isBought;
    }

    public Ballot vote(){
        int chanceToSkip = new Random().nextInt(100);
        if(chanceToSkip < getSkipVoteChance()){
            wentToVote = false;
            return null;
        }
        wentToVote = true;
        int chanceToVoteForMyGuy = new Random().nextInt(100);
        int chanceForValidBallot = new Random().nextInt(100);
        boolean isValidBallot = chanceForValidBallot < getValidBallotChance();
        if(chanceToVoteForMyGuy < getVoteForMyCandidateChance()){
            return new Ballot(this.candidate, isValidBallot, this);
        }
        else{
            return new Ballot(CIK.getRandomCandidate(), isValidBallot, this);
        }
    }

    protected abstract int getSkipVoteChance();
    protected abstract int getVoteForMyCandidateChance();
    protected abstract int getValidBallotChance();
    public abstract VoterType getType();

    public boolean wentToVote() {
        return wentToVote;
    }

    public boolean isBought() {
        return isBought;
    }

    public String getCity() {
        return city;
    }
}
