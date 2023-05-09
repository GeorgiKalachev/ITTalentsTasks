package snowWhiteHomework;

import snowWhiteHomework.characters.Dwarf;
import snowWhiteHomework.characters.Prince;
import snowWhiteHomework.characters.Queen;
import snowWhiteHomework.places.Castle;
import snowWhiteHomework.places.DwarfsHome;
import snowWhiteHomework.places.PrinceCastle;

public class Demo {

    public static void main(String[] args) {

        DwarfsHome dwarfsHome = new DwarfsHome();
        Castle caste = new Castle();
        PrinceCastle princecastle = new PrinceCastle();

        System.out.println("Once upon a time there was a Beautiful Queen. She had a magic mirror," +
                "and almost every day ask it \" Who is most beautiful person in the world. \" ");
        Queen queen = new Queen(caste);
        Dwarf dward1 = new Dwarf(dwarfsHome);
        Dwarf dward2 = new Dwarf(dwarfsHome);
        Dwarf dward3 = new Dwarf(dwarfsHome);
        Dwarf dward4 = new Dwarf(dwarfsHome);
        Dwarf dward5 = new Dwarf(dwarfsHome);
        Dwarf dward6 = new Dwarf(dwarfsHome);
        Dwarf dward7 = new Dwarf(dwarfsHome);
        Prince prince = new Prince(princecastle);


        while (true) {
            queen.askingTheMirror();

            if (!queen.getDaughterInLaw().getHomePlace().equals(caste)) {
                if (!queen.getDaughterInLaw().getHomePlace().equals(dwarfsHome)) {
                    queen.getDaughterInLaw().foundingNewHome(dwarfsHome);
                }
            }

            if (!queen.getDaughterInLaw().isAlive()) {
                prince.seeingPerson(queen.getDaughterInLaw());
                break;
            }
            passingYear();
        }


    }

    static void passingYear() {
        System.out.println("Passing another year...");
        for (int i = 0; i < Mirror.persons.size(); i++) {
            Mirror.persons.get(i).growUp();
        }
    }

}
