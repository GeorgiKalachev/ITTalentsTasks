package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = 1; rows <= num ; rows++) {
            for (int columns = 1; columns <= rows ; columns++) {
                System.out.print(columns);
            }

            for (int freespace = rows *2; freespace < num* 2 ; freespace++) {
                System.out.print(" ");
            }

            for (int columns = rows; columns >= 1 ; columns--) {
                System.out.print(columns);
            }

            System.out.println();
        }
    }
}
