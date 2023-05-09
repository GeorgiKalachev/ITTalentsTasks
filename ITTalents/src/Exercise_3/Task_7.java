package Exercise_3;

import java.util.Scanner;

public class Task_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Task7. Write a program that reads numbers A, B and C. A must be short. B and C must be < 7. The
        // * program has to invert the bits from number A on positions B and C. Print the new value of A.

        System.out.println("Enter short number A:");
        int numA = sc.nextInt();
        System.out.println("Enter two numbers B and C  < 7 ");
        int numB = sc.nextInt();
        int numC = sc.nextInt();

        if (numA < -32768 || numA > 32767){
            System.out.println("Wrong number A !");
        }
        if (numB > 7 || numC > 7){
            System.out.println("Wrong number B or C");
        }

        // We use XOR to invert bits with 1 on the same
        // position which is 1 shifted left with the
        // number of the position
        numA = numA ^ ( 1 << numB);
        numA = numA ^ ( 1 << numC);
        System.out.println(numA);
    }
}
