package test2.prezidentKrasi;

import test2.prezidentKrasi.candidates.Candidate;
import test2.prezidentKrasi.candidates.CandidateEducation;
import test2.prezidentKrasi.voters.Voter;
import test2.prezidentKrasi.voters.VoterType;

import java.util.*;

public class CIK {

    private Map<String, Set<Voter>> voters = new HashMap<>();
    private Set<Candidate> candidates = new HashSet<>();
    private Map<String, Set<Ballot>> sections = new HashMap();
    private Map<Candidate, Map<String, Integer>> rankings = new HashMap<>();

    public void startElections(){
        for(Set<Voter> votersByCity : this.voters.values()) {
            for (Voter v : votersByCity) {
                Ballot ballot = v.vote();
                if(ballot == null){
                    continue;
                }
                if (!sections.containsKey(v.getCity())) {
                    sections.put(v.getCity(), new HashSet<>());
                }
                sections.get(v.getCity()).add(ballot);
            }
        }
    }

    public Candidate getRandomCandidate() {
        return this.candidates.stream().findAny().get();
    }

    public void registerVoter(Voter voter){
        if(!this.voters.containsKey(voter.getCity())){
            this.voters.put(voter.getCity(), new HashSet<>());
        }
        this.voters.get(voter.getCity()).add(voter);
    }

    public void addCandidate(Candidate candidate){
        this.candidates.add(candidate);
    }

    public void rankCandidates() {
        for(Map.Entry<String, Set<Ballot>> e : this.sections.entrySet()){
            String city = e.getKey();
            Set<Ballot> ballots = e.getValue();
            for(Ballot ballot : ballots){
                if(!ballot.isValid()){
                    continue;
                }
                Candidate candidate = ballot.getCandidate();
                addVote(city, candidate);
            }

        }
    }

    private void addVote(String city, Candidate candidate){
        if(!rankings.containsKey(candidate)){
            rankings.put(candidate, new HashMap<>());
        }
        if(!rankings.get(candidate).containsKey(city)){
            rankings.get(candidate).put(city, 1);
        }
        else{
            int old = rankings.get(candidate).get(city);
            rankings.get(candidate).put(city, old+1);
        }
    }


    public void printStatistics() {
        printStat1();
        printStat2();
        printStat3();
        printStat4();
        printStat5();
        printStat6();
        printStat7();
        printStat8();
        printStat9();
        printStat10();
        printStat11();
        printStat12();
        printStat13();

        /*
        След провеждането на изборите избирателната комисия изважда следните статистики:
            1. Победител на изборите – кандидатът, генерирал най-много гласове.
            2. Runner up – кандидатът, на второ място от изборите.
            3. Общо гласували гласоподаватели (брой)
            4. Избирателна активност – процент гласоподаватели, които са гласували спрямо всички
            генерирани гласоподаватели от кампаниите на кандидатите.
            5. Избирателна активност по градове – класиране на градовете, подредени по процент
            избирателна активност.
            6. Купени гласове за изборите – процент гласове, които са на купени гласоподаватели
            спрямо всички подадени гласове.
            7. Невалидни бюлетини – процент невалидни бюлетини спрямо всички подадени бюлетини.
            8. Регистър на кандидатите по градове. Пример:
            София:
            Стефан Станев
            Иван Иванов
            Велико Търново:
            Красен Митрев
            Любомир Стойчев
            9. Любими кандидати на масите – списък с кандидати, за които са гласували най-много хора
            от съответната класова група. Понеже са три класови групи – за всяка трябва да се изведе
            кандидатът, за който най-много хора от тази група са дали гласа си.
            10. Градът с най-много избиратели
            11. Градът с най-малко невалидни бюлетини
            12. Градът с най-много купени гласове
            13. Брой гласове за кандидати без образование, брой гласове за кандидати с основно
            образование и брой гласове за кандидати с висше образование.
         */
    }

    private void printStat13() {
        System.out.println("STAT 13 ");
        Map<CandidateEducation, Integer> educationalVotes = new HashMap<>();
        for(Map.Entry<String, Set<Ballot>> e : sections.entrySet()){
            for(Ballot b : e.getValue()){
                CandidateEducation ce = b.getCandidate().getEducation();
                if(!educationalVotes.containsKey(ce)){
                    educationalVotes.put(ce, 1);
                }
                else{
                    educationalVotes.put(ce, educationalVotes.get(ce)+1);
                }
            }
        }
        for(Map.Entry<CandidateEducation, Integer> e : educationalVotes.entrySet()){
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }

    private void printStat12() {
        System.out.println("STAT 12 ");
        Map<String, Integer> citiesByCorruption = new HashMap<>();
        for(Map.Entry<String, Set<Ballot>> e : sections.entrySet()){
            int bought = 0;
            for(Ballot b : e.getValue()){
                if(b.getVoter().isBought()){
                    bought++;
                }
            }
            citiesByCorruption.put(e.getKey(), bought);
        }
        //sort cityWithMostValidBuletines by value
        //display first
    }

    private void printStat11() {
        System.out.println("STAT 11 ");
        Map<String, Integer> cityWithMostValidBuletines = new HashMap<>();
        for(Map.Entry<String, Set<Ballot>> e : sections.entrySet()){
            int valid = 0;
            for(Ballot b : e.getValue()){
                if(b.isValid()){
                    valid++;
                }
            }
            cityWithMostValidBuletines.put(e.getKey(), valid);
        }
        //sort cityWithMostValidBuletines by value
        //display first
    }

    private void printStat10() {
        System.out.println("STAT 10 ");
        Map<String, Integer> cityWithTotalVotes = new HashMap<>();
        for(Map.Entry<String, Set<Ballot>> e : sections.entrySet()){
            cityWithTotalVotes.put(e.getKey(), e.getValue().size());
        }
        //sort cityWithTotalVotes by value
        //display first
    }

    private void printStat9() {
        System.out.println("STAT 9 ");
        Map<Candidate, Map<VoterType, Integer>> votesByCast = new HashMap<>();
        for(Set<Ballot> set : this.sections.values()){
            for(Ballot b : set){
                Candidate c = b.getCandidate();
                VoterType vt = b.getVoter().getType();
                if(!votesByCast.containsKey(c)){
                    votesByCast.put(c, new HashMap());
                }
                if(!votesByCast.get(c).containsKey(vt)){
                    votesByCast.get(c).put(vt,1);
                }
                else{
                    int old  =votesByCast.get(c).get(vt);
                    votesByCast.get(c).put(vt, old+1);
                }
            }
        }
    }

    private void printStat8() {
        System.out.println("STAT 8 ");
        Map<String, Set<Candidate>> candidatesByCity = new HashMap<>();
        for(Map.Entry<String, Set<Ballot>> section : sections.entrySet()){
            String city = section.getKey();
            if(!candidatesByCity.containsKey(city)){
                candidatesByCity.put(city, new HashSet<>());
            }
            for(Ballot b : section.getValue()){
                candidatesByCity.get(city).add(b.getCandidate());
            }
        }
        for(Map.Entry<String, Set<Candidate>> e : candidatesByCity.entrySet()){
            System.out.println(e.getKey());
            for(Candidate c : e.getValue()){
                System.out.println("\t"+c.getName());
            }
        }
    }

    private void printStat7() {
        System.out.println("STAT 7 ");
        double total = 0;
        double invalid = 0;
        for(Set<Ballot> set : this.sections.values()){
            for(Ballot b : set){
                if(!b.isValid()){
                    invalid++;
                }
            }
            total += set.size();
        }
        System.out.println("Invalid % = " + (invalid / total * 100));
    }

    private void printStat6() {
        System.out.println("STAT 6 ");
        double totalVoters = 0;
        double bought = 0;
        for(Map.Entry<String, Set<Voter>> e: this.voters.entrySet()){
            for(Voter v : e.getValue()){
                totalVoters++;
                if(v.isBought()){
                    bought++;
                }
            }
        }
        System.out.println("Bought = " + (bought / totalVoters * 100));
    }

    private void printStat5() {
        System.out.println("STAT 5 ");
        Map<String, Double> activityByCity = new HashMap<>();
        for(Map.Entry<String, Set<Voter>> e: this.voters.entrySet()){
            String city = e.getKey();
            double totalVoters = 0;
            double active = 0;
            for(Voter v : e.getValue()){
                totalVoters++;
                if(v.wentToVote()){
                    active++;
                }
            }
            double activity = active / totalVoters * 100;
            activityByCity.put(city, activity);
        }
        List<Map.Entry<String, Double>> list = new ArrayList<>(activityByCity.entrySet());
        list.sort((o1, o2) -> Double.compare(o2.getValue(), o1.getValue()));
        list.stream().forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
    }

    private void printStat4() {
        System.out.println("STAT 4 ");
        double totalVoters = 0;
        double active = 0;
        for(Set<Voter> votersByCity : this.voters.values()){
            for(Voter v : votersByCity){
                totalVoters++;
                if(v.wentToVote()){
                    active++;
                }
            }
        }
        System.out.println("Aktivnost " + ((active / totalVoters)*100));
    }

    private void printStat3() {
        System.out.println("STAT 3 ");
        System.out.println("Total voters = " + this.voters.values().stream()
            .map(set -> set.size())
            .reduce(0 , (voters, total) -> voters + total));
    }

    private void printStat1() {
        System.out.println("STAT 1 ");
        List<Map.Entry<Candidate, Integer>> list = sortByVotes();
        System.out.println("WINNER IS " + list.get(0).getKey().getName());
    }

    private void printStat2() {
        System.out.println("STAT 2 ");
        List<Map.Entry<Candidate, Integer>> list = sortByVotes();
        System.out.println("WINNER IS " + list.get(1).getKey().getName());
    }
    
    private List<Map.Entry<Candidate, Integer>> sortByVotes(){
        Map<Candidate, Integer> ranks = new HashMap<>();
        for(Map.Entry<Candidate, Map<String, Integer>> e : rankings.entrySet()){
            Candidate c = e.getKey();
            int totalVotes = 0;
            for(int votes : e.getValue().values()){
                totalVotes += votes;
            }
            ranks.put(c, totalVotes);
        }
        List<Map.Entry<Candidate, Integer>> list = new ArrayList<>(ranks.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        return list;
    }
}
