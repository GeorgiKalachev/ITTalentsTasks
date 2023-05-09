package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int divide = 10000;
        while (num > 1) {
            System.out.println(num);

            num %= divide;
            divide /= 10;
        }
    }
}
