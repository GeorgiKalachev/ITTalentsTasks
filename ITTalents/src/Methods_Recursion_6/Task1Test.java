package Methods_Recursion_6;

import java.util.Scanner;

public class Task1Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cards;

        int tries = 0;
        int packs = 0;

        do{
            boolean hasPair = false;
            boolean correct = false;
            do {
                cards = sc.nextLine();
                tries++;
                for (int i = 0; i < cards.length(); i+=2) {
                    switch (cards.charAt(i)){
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case 'T':
                        case 'J':
                        case 'Q':
                        case 'K':
                        case 'A':
                            correct = true;
                            break;
                        default:
                            System.out.println("Invalid cards.");
                            correct = false;
                            packs = 0;
                            break;

                    }
                    if (!correct){
                        break;
                    }
                }


            }while (!correct);

            for (int i = 2; i <cards.length() ; i+=2) {
                if (cards.charAt(i) == cards.charAt(i - 2)) {
                    hasPair = true;
                    break;
                }
            }
            if (hasPair){
                packs++;
            }else{
                packs = 0;
            }


        }while(packs < 4);


        System.out.println(tries);
    }
}
