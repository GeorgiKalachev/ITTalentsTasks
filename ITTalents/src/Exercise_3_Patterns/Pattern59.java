package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        // Първа половина
        for (int rows = 1; rows <= num ; rows++) {

            for (int emptyLeft = 1; emptyLeft < rows ; emptyLeft++) {
                System.out.print(" ");
            }
            System.out.print(rows);

            for (int emptyTop = num* 2 - rows*2; emptyTop > 1; emptyTop--) {
                System.out.print(" ");
            }
            System.out.print((rows == num)? "":rows);
            System.out.println();
        }

        // Втора половина
        for (int rows = num-1; rows >= 1; rows--) {

            for (int emptyLeft = 1; emptyLeft <= rows-1 ; emptyLeft++) {
                System.out.print(" ");
            }
            System.out.print(rows);

            for (int emptyBottom = num*2 - rows*2; emptyBottom > 1; emptyBottom--) {
                System.out.print(" ");
            }
            System.out.print(rows);

            System.out.println();
        }

    }
}
