package test2.prezidentKrasi.voters;

import test2.prezidentKrasi.candidates.Candidate;

public class WealthyVoter extends Voter {

    public WealthyVoter(String name, Gender gender, String city, Candidate candidate, boolean isBought) {
        super(name, gender, city, candidate, isBought);
    }

    @Override
    protected int getSkipVoteChance() {
        return 50;
    }

    @Override
    protected int getVoteForMyCandidateChance() {
        return 50;
    }

    @Override
    protected int getValidBallotChance() {
        return 100;
    }

    @Override
    public VoterType getType() {
        return VoterType.WEALTHY;
    }
}
