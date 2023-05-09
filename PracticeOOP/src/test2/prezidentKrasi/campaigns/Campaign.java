package test2.prezidentKrasi.campaigns;

import test2.prezidentKrasi.Demo;
import test2.prezidentKrasi.candidates.Candidate;
import test2.prezidentKrasi.voters.MiddleClassVoter;
import test2.prezidentKrasi.voters.UneducatedVoter;
import test2.prezidentKrasi.voters.Voter;
import test2.prezidentKrasi.voters.WealthyVoter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public abstract class Campaign {

    public static test2.prezidentKrasi.CIK CIK;
    private LocalDate startDate;
    private LocalDate endDate;
    private int budget;
    private Candidate candidate;


    public Campaign(LocalDate startDate, LocalDate endDate, int budget, Candidate candidate) {
        if(!(startDate.plusDays(20).isAfter(endDate) ||
                startDate.plusDays(25).isBefore(endDate))){
            this.startDate = startDate;
            this.endDate = endDate;
        }
        else {
            this.startDate = startDate;
            this.endDate = startDate.plusDays(23);
        }
        this.budget = budget;
        this.candidate = candidate;
    }

    public void generateVoters(){
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < getMaxVotersPerDay(); j++) {
                boolean isBought = isVoterBought();
                if(isBought){
                    if(budget <= 50){
                        continue;
                    }
                    budget -= new Random().nextInt(21)+30;
                }
                int chance = new Random().nextInt(3);
                Voter voter = null;
                String name = "Voter " + i;
                Voter.Gender gender = new Random().nextBoolean() ? Voter.Gender.MALE : Voter.Gender.FEMALE;
                String city = Demo.getRandomCity();
                switch (chance){
                    case 0:
                        voter = new UneducatedVoter(name,gender, city, this.candidate, isBought);
                        break;
                    case 1:
                        voter = new MiddleClassVoter(name,gender, city, this.candidate, isBought);
                        break;
                    default:
                        voter = new WealthyVoter(name,gender, city, this.candidate, isBought);
                        break;
                }
                CIK.registerVoter(voter);
            }
        }
    }

    protected abstract boolean isVoterBought();

    protected abstract int getMaxVotersPerDay();

}
