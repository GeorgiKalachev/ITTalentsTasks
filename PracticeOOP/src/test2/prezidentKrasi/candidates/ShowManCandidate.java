package test2.prezidentKrasi.candidates;

import test2.prezidentKrasi.campaigns.Campaign;
import test2.prezidentKrasi.campaigns.NormalCampaign;

import java.time.LocalDate;

public class ShowManCandidate extends Candidate {


    public ShowManCandidate(String name, CandidateEducation education, int budget) {
        super(name, education, budget);
    }

    @Override
    protected Campaign startCampaign() {
        return new NormalCampaign(LocalDate.now(), LocalDate.now().plusDays(22), this.budget, this);
    }

    @Override
    protected boolean validEducation(CandidateEducation education) {
        return education == CandidateEducation.NONE ||
                education == CandidateEducation.BASIC ||
                education == CandidateEducation.HIGH;
    }
}
