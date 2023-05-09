package test2.prezidentKrasi.campaigns;

import test2.prezidentKrasi.candidates.Candidate;

import java.time.LocalDate;
import java.util.Random;

public class CriminalCampaign extends Campaign {

    public CriminalCampaign(LocalDate startDate, LocalDate endDate, int budget, Candidate candidate) {
        super(startDate, endDate, budget, candidate);
    }

    @Override
    protected boolean isVoterBought() {
        return new Random().nextBoolean();
    }

    @Override
    protected int getMaxVotersPerDay() {
        return 120;
    }
}
