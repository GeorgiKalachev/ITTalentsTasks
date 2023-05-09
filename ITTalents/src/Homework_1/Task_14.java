package Homework_1;

import java.util.Scanner;

public class Task_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();
        int num4 = sc.nextInt();

        boolean firstNumIsWhite = false;
        boolean secNumIsWhite = false;
        if ( num1 % 2 == 0 && num2 % 2 == 1 || num1 % 2 == 1 && num2 % 2 == 0){
            firstNumIsWhite = true;
        }
        if ( num3 % 2 == 0 && num4 % 2 == 1 || num3 % 2 == 1 && num4 % 2 == 0){
            secNumIsWhite = true;
        }

        if (firstNumIsWhite == secNumIsWhite){
            System.out.println("Positions are with same colour.");
        }else {
            System.out.println("Positions are with different colour.");
        }
    }
}
