package Exercise_3;

import java.util.Scanner;

public class Task_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        boolean isPrime = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime ? "Is Prime" : "Not Prime");
        // if (isPrime) {
        //    System.out.println("The number " + num + " is Prime.");
        //} else {
        //    System.out.println("The number " + num + " is Not prime.");
        // } *
    }
}
