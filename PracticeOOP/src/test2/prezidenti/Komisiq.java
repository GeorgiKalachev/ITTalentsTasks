package test2.prezidenti;

import musiciansTest2.musicInstrumentsTest2.instruments.Instrument;
import test2.prezidenti.candidats.*;

import java.net.Inet4Address;
import java.time.LocalDate;
import java.util.*;

public class Komisiq {

    private Map<String, Set<Biuletina>> biuletini = new HashMap<>();

    private Map<String, Set<Glasopodavatel>> gradove = new HashMap<>();

    private Map<Candidat, Map<String, Integer>> ranking = new HashMap<>();
    HashSet<Candidat> candidats = new HashSet<>();


    public void addingTenCandidats() {
        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            int chance = r.nextInt(3);
            Candidat candidat;
            switch (chance) {
                case 0 ->
                        candidat = new Mutra(Util.getRandomName(), Util.getRandomEducation(), new Random().nextInt(50000, 300000));
                case 1 ->
                        candidat = new Politic(Util.getRandomName(), Util.getRandomEducation(), new Random().nextInt(50000, 300000));
                default ->
                        candidat = new Showmen(Util.getRandomName(), Util.getRandomEducation(), new Random().nextInt(50000, 300000));
            }
            candidats.add(candidat);
            System.out.println(candidat.getName() + " added");
        }
    }

    public void makingCampagne(LocalDate start, LocalDate end) {

        for (Candidat candidat : this.candidats) {
            candidat.organizeCampaigne(start, end);
            System.out.println(candidat.getName() + " make campagne ");
        }

    }

    public void addGlasuvasht(Glasopodavatel glasuvasht) {

        // check if grad is there
        if (!gradove.containsKey(glasuvasht.getCity())) {
            gradove.put(glasuvasht.getCity(), new HashSet<>());
        }

        gradove.get(glasuvasht.getCity()).add(glasuvasht);

    }

    public void addingGlasuvashti() {
        for (Candidat candidat : this.candidats) {
            HashSet<Glasopodavatel> glasove = candidat.getGlasopodavateli();
            for (Glasopodavatel glas : glasove) {
                if (glas.isGoingToVote()) {
                    addGlasuvasht(glas);
                }
            }
            System.out.println(candidat.getName() + " make campagne with " + glasove.size() + " members");
        }

    }

    public void addBiuletina(Biuletina biuletina) {

        // check if type is there
        if (!biuletini.containsKey(biuletina.getCity())) {
            biuletini.put(biuletina.getCity(), new HashSet<>());
        }

        biuletini.get(biuletina.getCity()).add(biuletina);

    }

    public void rankingList() {

        for (Map.Entry<String, Set<Biuletina>> e : biuletini.entrySet()) {
            String city = e.getKey();
            Set<Biuletina> ballots = e.getValue();
            for (Biuletina biuletina : ballots) {
                if (!biuletina.isValid()) {
                    continue;
                }
                Candidat candidat = biuletina.getCandidat();
                addVote(city, candidat);
            }

        }

    }

    private void addVote(String city, Candidat candidat) {

        if (!ranking.containsKey(candidat)) {
            ranking.put(candidat, new HashMap<>());
        }
        if (!ranking.get(candidat).containsKey(city)) {
            ranking.get(candidat).put(city, 1);
        } else {
            int old = ranking.get(candidat).get(city);
            ranking.get(candidat).put(city, old + 1);
        }


    }

    public void startVoting() {

        for (Map.Entry<String, Set<Glasopodavatel>> grad : gradove.entrySet()) {

            Set<Glasopodavatel> glas = grad.getValue();
            for (Glasopodavatel glasuvasht : glas) {
                boolean isMistaken = false;
                int chanceMistake = new Random().nextInt(100);
                if (glasuvasht.getChanceToMistake() < chanceMistake) {
                    isMistaken = true;
                }
                Biuletina biuletina = new Biuletina(glasuvasht.getCandidat(candidats), glasuvasht.getCity(), isMistaken);

                addBiuletina(biuletina);


            }
        }


    }

    //1. Победител на изборите – кандидатът, генерирал най-много гласове.
    public void stats1() {

        Map<Candidat, Integer> ranks = new HashMap<>();

        for (Map.Entry<Candidat, Map<String, Integer>> e : ranking.entrySet()) {
            Candidat c = e.getKey();
            int totalVotes = 0;
            for (int votes : e.getValue().values()) {
                totalVotes += votes;
            }
            ranks.put(c,totalVotes);
        }

        List<Map.Entry<Candidat,Integer>> list = new ArrayList<>(ranks.entrySet());
        list.sort((o1,o2) -> o2.getValue() - o1.getValue());

        System.out.println("Winner is " + list.get(0).getKey().getName());
        System.out.println("Second  is " + list.get(1).getKey().getName());
    }

    public void stats3(){
        //3. Общо гласували гласоподаватели (брой)
        System.out.println("Total voters : " + this.gradove.values().stream()
                .map(set -> set.size())
                .reduce(0, (glas,total ) -> glas + total));
    }

    public void stats4(){
        //Избирателна активност – процент гласоподаватели, които са гласували спрямо всички
        //генерирани гласоподаватели от кампаниите на кандидатите.
        Double glasuvali = Double.valueOf(this.gradove.values().stream()
                .map(set -> set.size())
                .reduce(0, (glas,total ) -> glas + total));

        double vsichki = 0;

        for (Candidat candidats1 : this.candidats) {
            Set<Glasopodavatel> glasopodavatels = candidats1.getGlasopodavateli();
            vsichki += glasopodavatels.size();
        }

        System.out.println("Activity : " + (glasuvali/vsichki) * 100);
    }

    public void stats5(){
        //Избирателна активност по градове – класиране на градовете, подредени по процент
        //избирателна активност.


        Map<String,Double> activityByCity = new HashMap<>();
        for(Map.Entry<String,Set<Glasopodavatel>> e : this.gradove.entrySet()){
            String city = e.getKey();

            double totalVots = (long) e.getValue().size();

            double vsichki = 0;

            for (Candidat candidats1 : this.candidats) {
                Set<Glasopodavatel> glasopodavatels = candidats1.getGlasopodavateli();
                vsichki += glasopodavatels.stream().filter(o -> o.getCity().equals(city))
                        .count();
            }

            activityByCity.put(city,(totalVots/vsichki) * 100);
        }

        List<Map.Entry<String,Double>> list = new ArrayList<>(activityByCity.entrySet());
        list.sort((o1,o2) -> Double.compare(o2.getValue(), o1.getValue()));
        list.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

    }
}
