package test2.prezidentKrasi.voters;

import test2.prezidentKrasi.candidates.Candidate;

public class MiddleClassVoter extends Voter {

    public MiddleClassVoter(String name, Gender gender, String city, Candidate candidate, boolean isBought) {
        super(name, gender, city, candidate, isBought);
    }

    @Override
    protected int getSkipVoteChance() {
        return 30;
    }

    @Override
    protected int getVoteForMyCandidateChance() {
        return 70;
    }

    @Override
    protected int getValidBallotChance() {
        return 90;
    }

    @Override
    public VoterType getType() {
        return VoterType.MIDDLE_CLASS;
    }
}
