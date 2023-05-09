package Homework_2;

import java.util.Random;
import java.util.Scanner;

public class Task_11Extra {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            for (int j = n - i; j > 1; j--) {
                System.out.print(" ");
            }
            for (int h = 0; h <= i; h++) {
                // проверка да принти звезда само в края
                if (i < n - 1 && h > 0 && h < i) {
                    Random r = new Random();
                    int chance = r.nextInt(100);
                    char randomCharIndex = (char) r.nextInt(5000);
                    if (chance < 30){
                        System.out.print(randomCharIndex + " ");
                    }else {
                        System.out.print("  ");
                    }
                } else {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }
    }
}
