package test2.prezidentKrasi.campaigns;

import test2.prezidentKrasi.candidates.Candidate;

import java.time.LocalDate;

public class NormalCampaign extends Campaign {

    public NormalCampaign(LocalDate startDate, LocalDate endDate, int budget, Candidate candidate) {
        super(startDate, endDate, budget, candidate);
    }

    @Override
    protected boolean isVoterBought() {
        return false;
    }

    @Override
    protected int getMaxVotersPerDay() {
        return 100;
    }
}
