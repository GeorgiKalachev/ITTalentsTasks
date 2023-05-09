package test2.prezidentKrasi.candidates;

import test2.prezidentKrasi.campaigns.Campaign;

import java.util.Objects;

public abstract class Candidate {

    private String name;
    private CandidateEducation education;
    protected int budget;
    private Campaign campaign;

    public Candidate(String name, CandidateEducation education, int budget) {
        this.name = name;
        this.budget = budget;
        if (validEducation(education)) {
            this.education = education;
        }
        else{
            this.education = CandidateEducation.NONE;
        }
        this.campaign = startCampaign();
    }

    public Campaign getCampaign() {
        return campaign;
    }

    protected abstract Campaign startCampaign();
    protected abstract boolean validEducation(CandidateEducation education);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public CandidateEducation getEducation() {
        return education;
    }
}
