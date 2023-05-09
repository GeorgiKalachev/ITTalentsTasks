package consulting010823;

import java.util.Scanner;

public class Test1Task1_1 {

    public static void main(String[] args) {
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter hand");
            String hand = sc.nextLine();
            if(!validHand(hand)){
                System.out.println("Invalid cards given");
                continue;
            }
            if(hasTerza(hand)){
                break;
            }
        }
    }

    static boolean hasTerza(String hand){
        String[] cards = hand.split(" ");
        //if no 3 cards with same suit - return false
        //if we have 7 8 and 9 OR 8 9 and T OR 9 T and J OR T J and Q OR J Q and K OR Q K and A

        // 0  1  2  3  4  5  6  7
        //[7, 8, 9, T, J, Q, K, A]

        //Qs Qh Ks Ts As
        //[5, 5, 6, 3, 7]
        return true;
    }


    static boolean validHand(String hand){
        //6s Qh ....
        String[] cards = hand.split(" ");
        if(cards.length != 5){
            return false;
        }
        for (int i = 0; i < cards.length; i++) {
            if(cards[i].length() != 2){
                return false;
            }
            String allSuits = "schd";
            String allStrengths = "789TJQKA";
            if(!allStrengths.contains(cards[i].substring(0, 1))){
                return false;
            }
            if(!allSuits.contains(cards[i].substring(1))){
                return false;
            }
        }
        return true;
    }
}
