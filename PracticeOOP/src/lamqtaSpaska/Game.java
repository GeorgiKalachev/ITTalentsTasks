package lamqtaSpaska;

import lamqtaSpaska.creatures.Creature;
import lamqtaSpaska.creatures.Hero;
import lamqtaSpaska.creatures.Spaska;
import lamqtaSpaska.items.Item;
import lamqtaSpaska.places.Forest;
import lamqtaSpaska.places.Tavern;

import java.util.Random;
import java.util.Scanner;


public class Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Forest gorata = new Forest();
        Creature spaska = new Spaska();
        Tavern hana = new Tavern("Hana");


        System.out.println("Welcome to the lands of Spaska !");
        String name;
        do {
            System.out.println("Enter name for your Hero :");
            name = sc.next();
        } while (isValidName(name));

        Hero hero = new Hero(name);

        int num;
        boolean spaskaIsKilled = false;


        do {
            hero.showStats();
            boolean winFight = false;
            do {
                System.out.println("""
                        Choose what to do ?\s
                        1 - Go to forest  \s
                        2 - Go to tavern\s
                        3 - Go to loot - equip Items \s
                        4 - Go try to kill the Fearless, Firebreath Magnificent SPASKA""");
                num = sc.nextInt();
            } while (num < 1 || num > 4);
            switch (num) {
                case 1 -> { // go to forest
                    do {
                        System.out.println("""
                                Who do you wanna fight ?\s
                                1 - weak bastard\s
                                2 - medium bastard\s
                                3 - hard bastard\s
                                4 - Dig for gold ( 30 % to be attacked )""");
                        num = sc.nextInt();
                    } while (num < 1 || num > 4);
                    switch (num) {
                        case 1 -> winFight = fight(hero, gorata.getKopeleta()[0]);
                        case 2 -> winFight = fight(hero, gorata.getKopeleta()[1]);
                        case 3 -> winFight = fight(hero, gorata.getKopeleta()[2]);
                        case 4 -> {
                            winFight = gorata.digging(hero);
                            if (winFight) {
                                num = (gorata.getOponent() + 1);
                            }
                        }
                    }
                    gorata.reviveBastards();
                    if (winFight) {
                        hero.setMonsterKills();
                        int answer;
                        Item item = gorata.getKopeleta()[num - 1].dropItem();
                        if (item.getName().equals("null")) {
                            System.out.println("Nothing dropped.");
                        } else {
                            do {
                                System.out.println(item.getName() + " is dropped. Do you wanna get it 1 - yes | 2 - no ?");
                                answer = sc.nextInt();
                            } while (answer < 1 || answer > 2);
                            if (answer == 1) {
                                if (hero.getLootSize() >= 5) {
                                    hero.showLoot();
                                    do {
                                        System.out.println("Loot is full. What to exchange ?");
                                        answer = sc.nextInt();
                                    } while (answer < 1 || answer > 5);
                                    hero.removeItemFromloot(answer);
                                    hero.getDroppedItem(item);
                                } else {
                                    hero.getDroppedItem(item);
                                }
                            }
                        }
                    }
                }
                case 2 -> { // go tavern
                    do {
                        System.out.println("What do you wanna do ? \n 1 - sleep and revive \n 2 - sell items ");
                        num = sc.nextInt();
                    } while (num < 1 || num > 2);
                    switch (num) {
                        case 1 -> hana.sleepOver(hero);
                        case 2 -> {
                            if (hero.getLootSize() < 1) {
                                System.out.println("Your loot is empty !");
                            } else {
                                hero.showLoot();
                                do {
                                    System.out.println("What to sell?");
                                    num = sc.nextInt();
                                } while (num < 1 || num > hero.getLootSize());
                                hana.buyItem(hero.sellItem(num));
                            }

                        }
                    }
                }
                case 3 -> { // Wear Items
                    if (hero.getLootSize() < 1) {
                        System.out.println("Your loot is empty !");
                    } else {
                        hero.showLoot();
                        do {
                            System.out.println("What to equip?");
                            num = sc.nextInt();
                        } while (num < 1 || num > hero.getLootSize());
                        hero.equipFromLoot(num);
                    }

                }
                case 4 -> { // go try spaska

                    if (fight(hero, spaska)) {
                        spaskaIsKilled = true;
                    }
                }
            }

        } while (!spaskaIsKilled);
        System.out.println("Congratulations you WIN ! SPASKA is killed !");

        hero.showFinalStats();

    }

    private static boolean isValidName(String name) {
        return name.matches("[a-zA-Z]+") && name.length() > 2;
    }

    public static boolean fight(Creature f1, Creature f2) {

        while (true) {
            if (new Random().nextBoolean()) {

                if (fighting(f1, f2)) {
                    System.out.println(f2.getName() + "Wins");
                    return false;
                }
                if (fighting(f2, f1)) {
                    System.out.println(f1.getName() + "Wins");
                    return true;
                }
            } else {
                if (fighting(f1, f2)) {
                    System.out.println(f2.getName() + "Wins");
                    return false;
                }
                if (fighting(f2, f1)) {
                    System.out.println(f1.getName() + "Wins");
                    return true;
                }
            }
        }
    }


    static boolean fighting(Creature f1, Creature f2) {

        if (f1.isAlive()) {
            f1.hit(f2);
            return false;
        } else {
            return true;
        }


    }

}


