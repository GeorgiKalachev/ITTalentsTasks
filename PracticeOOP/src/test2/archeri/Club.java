package test2.archeri;

import test2.archeri.archers.Archer;
import test2.archeri.archers.ArcherType;
import test2.archeri.bows.Bow;

import java.util.*;

public class Club {

    private String name;
    private String address;
    private String coach;
    private Set<Archer> archers;
    public static int uniqueId = 1;
    //archer type -> map of names->totalPoints
    private Map<ArcherType, Map<String, Integer>> rankings;


    public Club(String name, String address, String coach) {
        this.name = name;
        this.address = address;
        this.coach = coach;
        this.archers = new HashSet<>();
        this.rankings = new HashMap<>();
    }

    public void startTournament(){
        this.rankings.put(ArcherType.JUNIOR, new HashMap<>());
        this.rankings.put(ArcherType.SENIOR, new HashMap<>());
        this.rankings.put(ArcherType.VETERAN, new HashMap<>());

        List<Archer> participants = new ArrayList(this.archers);
        System.out.println("TOURNAMENT STARTS, LIST OF PARTICIPANTS:");
        participants.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));
        participants.stream()
                .peek(p -> p.incrementTournament())
                .peek(p -> System.out.println(p.getName()))
                .forEach(p -> {
                    int totalPoints = p.shoot();
                    rankings.get(p.getType()).put(p.getName(), totalPoints);
                });
        System.out.println("RANKINGS!");

        for(Map.Entry<ArcherType, Map<String, Integer>> e : this.rankings.entrySet()){
            System.out.println(e.getKey()+ ":");
            List<Map.Entry<String, Integer>> list = new ArrayList<>(e.getValue().entrySet());
            list.sort((o1, o2) -> o2.getValue() - o1.getValue());
            for(Map.Entry<String, Integer> e1 : list){
                System.out.println("\t" + e1.getKey() + " - " + e1.getValue());
            }
        }
        System.out.println("STATISTICS!");
        prepareStat1();
        prepareStat2();
        prepareStat3();
        prepareStat4();
        prepareStat5();
        prepareStat6();

        participants.stream().forEach(p -> {
            p.resetTens();
            p.resetMisses();
        });
    }

    private void prepareStat6() {
        System.out.println("STAT 6");
        this.archers.stream()
                .filter(a -> a.getGender() == Archer.Gender.MALE)
                .filter(a -> a.getBow().getBowType() == Bow.BowType.CARBON)
                .sorted((a1, a2) -> a2.getExp() - a1.getExp())
                .forEach(a -> System.out.println(a.getName() + " - " + a.getExp()));
    }

    private void prepareStat5() {
        System.out.println("STAT 5");
        this.archers.stream()
                .filter(p -> p.getGender() == Archer.Gender.FEMALE)
                .sorted((a1, a2) -> {
                  double a1TotalPoints = this.rankings.get(a1.getType()).get(a1.getName());
                  double a1MaxPossible = a1.getMaxArrows()*10;
                  double a1Accuracy =  a1TotalPoints / a1MaxPossible * 100;

                  double a2TotalPoints = this.rankings.get(a2.getType()).get(a2.getName());
                  double a2MaxPossible = a2.getMaxArrows()*10;
                  double a2Accuracy =  a2TotalPoints / a2MaxPossible * 100;
                  return Double.compare(a2Accuracy, a1Accuracy);
                })
                .forEach(p -> {
                    double totalPoints = this.rankings.get(p.getType()).get(p.getName());
                    double maxPossible = p.getMaxArrows()*10;
                    double accuracy =  totalPoints / maxPossible * 100;
                    System.out.println(p.getName() + " - " + accuracy);
                });
    }

    private void prepareStat4() {
        System.out.println("STAT 4");
        String nekaduren = this.archers.stream()
                .sorted((o1, o2) -> o2.getMisses() - o1.getMisses())
                .findFirst().get().getName();
        System.out.println("Nekaduren - " + nekaduren);
    }

    private void prepareStat3() {
        System.out.println("STAT 3");
        String sharpshooter = this.archers.stream()
                .sorted((a1, a2) -> ((a2.getTens() / a2.getMaxArrows()) * 100) - ((a1.getTens() / a1.getMaxArrows()) * 100))
                .findFirst().get().getName();
        System.out.println("Sharpshooter = " + sharpshooter);
    }

    private void prepareStat2() {
        System.out.println("STAT 2");
        this.rankings.entrySet().stream()
                .forEach(e -> {
                    System.out.print(e.getKey()+":");
                    Collection<Integer> points = e.getValue().values();
                    long totalPoints = points.stream().reduce(0, (total, points1) -> total+points1);
                    System.out.println(totalPoints / points.size());
                });
//        System.out.println("AVG POINTS");
//        for(Map.Entry<ArcherType, Map<String, Integer>> e : this.rankings.entrySet()){
//            System.out.print(e.getKey() + ":");
//            int total = 0;
//            for(int totalPoints : e.getValue().values()){
//                total += totalPoints;
//            }
//            System.out.println(total / e.getValue().values().size());
//        }
    }

    private void prepareStat1() {
        System.out.println("STAT 1");
        this.rankings.entrySet().stream()
            .forEach(e -> {
                ArrayList<Map.Entry<String, Integer>> list
                        = new ArrayList<>(e.getValue().entrySet());
                list.sort((o1, o2) -> o2.getValue() - o1.getValue());
                Map.Entry winner = list.get(0);
                System.out.println(winner.getKey() + " - " + winner.getValue());
            });


    }

    public void addArcher(Archer a) {
        this.archers.add(a);
    }
}

