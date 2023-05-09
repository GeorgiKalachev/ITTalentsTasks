package Homework_1;

import java.util.Scanner;

public class Task_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount of litres:");
        int litres = sc.nextInt();

        int countTimes = litres / 5;
        int leftLitres = litres % 5;

        if (leftLitres == 2 || leftLitres == 4){
            if (leftLitres == 2){
                System.out.printf("%d times with 2L. buckets, %d times with 3L. buckets, " +
                        "and extra 1 time with 2L. bucket", countTimes, countTimes);
            }else {
                System.out.printf("%d times with 2L. buckets, %d times with 3L. buckets, " +
                        "and extra 2 times with 2L. bucket", countTimes, countTimes);
            }
        } else if (leftLitres == 3) {
            System.out.printf("%d times with 2L. buckets, %d times with 3L. buckets, " +
                    "and extra 1 times with 3L. bucket", countTimes, countTimes);
        }else {
            System.out.printf("%d times with 2L. and 3L. buckets",countTimes);
        }
    }
}
