package Homework_1;

import java.util.Scanner;

public class Task_16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a three digit number: ");
        int number = sc.nextInt();


        int firstDig = number / 100;
        int secDig = (number % 100) / 10;
        int thirdDig = number % 10;

        if (firstDig == secDig && secDig == thirdDig){
            System.out.println("Numbers are equal.");
        } else if (firstDig > secDig && secDig > thirdDig) {
            System.out.println("Numbers are in descending order");
        } else if (firstDig < secDig && secDig < thirdDig) {
            System.out.println("Numbers are in ascending order");
        }else {
            System.out.println("Numbers are unordered.");
        }
    }
}
