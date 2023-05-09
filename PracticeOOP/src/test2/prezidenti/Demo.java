package test2.prezidenti;


import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {

        Komisiq komisiq = new Komisiq();

        komisiq.addingTenCandidats();

        komisiq.makingCampagne(LocalDate.of(2020,2, 5),LocalDate.of(2020,2,25));

        komisiq.addingGlasuvashti();

        komisiq.startVoting();

        komisiq.rankingList();

        komisiq.stats1();
        komisiq.stats4();
        komisiq.stats3();
        komisiq.stats5();


    }
}
