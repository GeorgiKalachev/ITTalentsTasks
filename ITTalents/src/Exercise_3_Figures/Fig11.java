package Exercise_3_Figures;

import java.util.Scanner;

public class Fig11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = 1; rows <= num ; rows++) {

            for (int emptySpace = rows; emptySpace < num ; emptySpace++) {
                System.out.print("     ");
            }
            System.out.print("  o  ******");
            for (int emptyLeft = 1; emptyLeft < rows ; emptyLeft++) {
                System.out.print("     ");
            }
            System.out.println("*");


            for (int emptySpace = rows; emptySpace < num ; emptySpace++) {
                System.out.print("     ");
            }
            System.out.print(" /|\\ *");
            for (int emptyLeft = 1; emptyLeft <=rows ; emptyLeft++) {
                System.out.print("     ");
            }
            System.out.println("*");


            for (int emptySpace = rows; emptySpace < num ; emptySpace++) {
                System.out.print("     ");
            }
            System.out.print(" / \\ *");
            for (int emptyLeft = 1; emptyLeft <=rows ; emptyLeft++) {
                System.out.print("     ");
            }
            System.out.println("*");


        }


        for (int stars = 1; stars <= num +1 ; stars++) {
            System.out.print("*****");
        }
        System.out.println("**");


        
    }
}
