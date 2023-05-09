package Homework_2;

import java.util.Scanner;

public class Task_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 0;
        for (int cards = 2; cards <= 14; cards++) {

            for (int paint = 1; paint <= 4; paint++) {
                count++;
                if (count >= num) {
                    if (cards == 11) {
                        System.out.print("Jack ");
                    } else if (cards == 12) {
                        System.out.print("Lady ");
                    } else if (cards == 13) {
                        System.out.print("King ");
                    } else if (cards == 14) {
                        System.out.print("Ase ");
                    } else {
                        System.out.print(cards + " ");
                    }
                    switch (paint) {
                        case 1:
                            System.out.print("spatiq,");
                            break;
                        case 2:
                            System.out.print("karo,");
                            break;
                        case 3:
                            System.out.print("kupa,");
                            break;
                        case 4:
                            System.out.print("pika,");
                            break;
                    }
                }

            }

        }
    }
}
