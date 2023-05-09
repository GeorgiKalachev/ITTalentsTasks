package Homework_1;

import java.util.Scanner;

public class Task_8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter four digit number:");
        int number = sc.nextInt();

        int firstDig = number / 1000;
        int secDig = (number % 1000) / 100;
        int thirdDig = (number % 100) / 10;
        int fourthDig = number % 10;

        int firstMargeNum = (firstDig * 10) + fourthDig;
        int secMargeNum = (secDig * 10) + thirdDig;

        if (firstMargeNum > secMargeNum) {
            System.out.println("First num is bigger ("+firstMargeNum+ '>'+secMargeNum +')');
        } else if (firstMargeNum == secMargeNum) {
            System.out.println("Numbers are equal ("+firstMargeNum+ '='+secMargeNum +')');
        } else  {
            System.out.println("First num is lower ("+firstMargeNum+ '<'+secMargeNum +')');
        }
    }
}
