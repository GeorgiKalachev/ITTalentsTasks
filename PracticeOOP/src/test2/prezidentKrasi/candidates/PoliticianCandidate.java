package test2.prezidentKrasi.candidates;

import test2.prezidentKrasi.campaigns.Campaign;
import test2.prezidentKrasi.campaigns.CriminalCampaign;
import test2.prezidentKrasi.campaigns.NormalCampaign;

import java.time.LocalDate;
import java.util.Random;

public class PoliticianCandidate extends Candidate {

    public PoliticianCandidate(String name, CandidateEducation education, int budget) {
        super(name, education, budget);
    }

    @Override
    protected Campaign startCampaign() {
        if(new Random().nextBoolean()){
            return new CriminalCampaign(LocalDate.now(), LocalDate.now().plusDays(22), this.budget, this);
        }
        else{
            return new NormalCampaign(LocalDate.now(), LocalDate.now().plusDays(22), this.budget, this);
        }
    }

    @Override
    protected boolean validEducation(CandidateEducation education) {
        return education == CandidateEducation.MEDIUM ||
                education == CandidateEducation.HIGH;
    }
}
