package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern17 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        for (int rows = 1; rows <= num; rows++) {
            int n = 1;

            for (int negative = rows ; negative >= 1 ; negative--) {
                System.out.print(negative);
            }

            for (int columns = rows; columns <num ; columns++) {
                System.out.print(++n);
            }

            System.out.println();
        }
    }
}
