package test2.prezidentKrasi;

import test2.prezidentKrasi.candidates.Candidate;
import test2.prezidentKrasi.voters.Voter;

public class Ballot {

    private Candidate candidate;
    private boolean isValid;
    private Voter voter;

    public Ballot(Candidate candidate, boolean isValid, Voter voter) {
        this.candidate = candidate;
        this.isValid = isValid;
        this.voter = voter;
    }

    public boolean isValid() {
        return isValid;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public Voter getVoter() {
        return voter;
    }
}
