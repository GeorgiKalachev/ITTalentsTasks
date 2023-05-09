package Homework_1;

import java.util.Scanner;

public class Task_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int day = sc.nextInt();
        int month = sc.nextInt();
        int year = sc.nextInt();

        boolean isLeapYear = false;

        if (year % 4 == 0) {
            isLeapYear = true;
            if (year % 100 == 0) {
                isLeapYear = false;
            }
            if (year % 400 == 0) {
                isLeapYear = true;
            }
        }

        boolean isBigMonth = false;

        if (month % 2 == 1 && month < 8 || month > 7 && month % 2 == 0) {
            isBigMonth = true;
        }


        if (isBigMonth && day >= 31) {
            day = 0;
        }

        if (!isBigMonth && day >= 30) {
            day = 0;
        }

        if (month == 2) {
            if (isLeapYear && day == 29) {
                day = 0;
            } else if (!isLeapYear && day == 28) {
                day = 0;
            }
        }

        if (day == 0) {
            month++;
            if (month == 13) {
                month = 1;
                year++;
            }
        }
        day++;

        System.out.println(day + "," + month + "," + year);
    }
}
