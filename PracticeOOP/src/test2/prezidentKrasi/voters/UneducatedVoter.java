package test2.prezidentKrasi.voters;

import test2.prezidentKrasi.candidates.Candidate;

public class UneducatedVoter extends Voter {


    public UneducatedVoter(String name, Gender gender, String city, Candidate candidate, boolean isBought) {
        super(name, gender, city, candidate, isBought);
    }

    @Override
    protected int getSkipVoteChance() {
        return 10;
    }

    @Override
    protected int getVoteForMyCandidateChance() {
        return 100;
    }

    @Override
    protected int getValidBallotChance() {
        return 60;
    }

    @Override
    public VoterType getType() {
        return VoterType.UNEDUCATED;
    }
}
