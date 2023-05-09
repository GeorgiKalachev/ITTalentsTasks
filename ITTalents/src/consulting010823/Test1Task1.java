package consulting010823;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Test1Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tries = 0;
        int pairs = 0;
        while (true) {
            //read a hand
            String hand = sc.nextLine();
            //validate hand
            if(!validHand(hand)) {
                //if invalid -> continue, pairs = 0
                System.out.println("Invalid cards given!");
                pairs = 0;
                continue;
            }
            tries++;
            if(hasPair(hand)){
                pairs++;
            }
            else{
                pairs = 0;
            }
            if(pairs == 4){
                System.out.println("Total tries = " + tries);
                break;
            }
        }
    }

    static boolean hasPair(String hand){
        String[] cards = hand.split(" ");
        for (int i = 0; i < cards.length; i++) {
            for (int j = 0; j < cards.length; j++) {
                if(i != j && cards[i].equals(cards[j])){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean validHand(String hand){
        String[] cards = hand.split(" ");
        if(cards.length != 5){
            return false;
        }
        for (int i = 0; i < cards.length; i++) {
            if(cards[i].length() != 1){
                return false;
            }
        }
        String possible = "23456789TJQKA";
        for (int i = 0; i < cards.length; i++) {
            if(!possible.contains(cards[i])){
                return false;
            }
        }
        return true;
    }
}
