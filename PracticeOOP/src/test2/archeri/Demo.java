package test2.archeri;

import test2.archeri.archers.Archer;
import test2.archeri.archers.JuniorArcher;
import test2.archeri.archers.VeteranArcher;
import test2.archeri.archers.SeniorArcher;
import test2.archeri.bows.AluminumBow;
import test2.archeri.bows.WoodenBow;
import test2.archeri.bows.CarbonBow;

import java.util.Random;

public class Demo {

    public static void main(String[] args) {


        Club club = new Club("IT Archer", "Alexi Rilets", "Krasi");
        for (int i = 0; i < 40; i++) {
            Archer a = null;
            int archerTypeChance = new Random().nextInt(3);
            Archer.Gender gender = new Random().nextBoolean() ? Archer.Gender.FEMALE : Archer.Gender.MALE;
            int age = new Random().nextInt(40) + 12;
            switch (archerTypeChance){
                case 0 :
                    a = new JuniorArcher("Junior " + i, gender, new WoodenBow(2, "Hoyt", 20), age);
                    break;
                case 1 :
                    AluminumBow bow = new Random().nextBoolean() ?
                            new AluminumBow(3, "Hoyt", 25)
                            :
                            new CarbonBow(4, "Hoyt", 26);
                    a = new SeniorArcher("Senior " + i, gender, age, bow);
                    break;
                default:
                    a = new VeteranArcher("Veteran " + i, gender, age, new CarbonBow(4, "Hoyt", 27));
                    break;
            }
            club.addArcher(a);
        }

        club.startTournament();

    }
}
