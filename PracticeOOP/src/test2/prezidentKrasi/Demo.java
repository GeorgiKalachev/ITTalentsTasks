package test2.prezidentKrasi;

import test2.prezidentKrasi.campaigns.Campaign;
import test2.prezidentKrasi.candidates.*;
import test2.prezidentKrasi.voters.Voter;

import java.util.Random;

public class Demo {

    private static final String[] CITIES = {"Sofia", "Varna", "Plovdiv"};

    public static void main(String[] args) {

        CIK cik = new CIK();
        Voter.CIK = cik;
        Campaign.CIK = cik;

        for (int i = 0; i < 10; i++) {
            Candidate candidate = null;
            int chance = new Random().nextInt(3);
            switch (chance){
                case 0 :
                    candidate = new BanditCandidate("Bandid " + i, CandidateEducation.NONE, 200000);
                    break;
                case 1:
                    candidate = new PoliticianCandidate("Politician " + i, CandidateEducation.BASIC, 250000);
                    break;
                default:
                    candidate = new ShowManCandidate("Showman " + i, CandidateEducation.HIGH, 290000);
                    break;
            }
            cik.addCandidate(candidate);
            candidate.getCampaign().generateVoters();
        }
        cik.startElections();
        cik.rankCandidates();
        cik.printStatistics();

    }

    public static String getRandomCity(){
        return CITIES[new Random().nextInt(CITIES.length)];
    }
}
