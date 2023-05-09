package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = 1; rows <= num ; rows++) {
            for (int columns = 1; columns <= rows ; columns++) {
                System.out.print(columns);
            }
            for (int columns = rows-1; columns >=1 ; columns--) {
                System.out.print(columns);
            }
            System.out.println();
        }
        for (int rows = num -1; rows >= 1 ; rows--) {
            for (int columns = 1; columns <= rows ; columns++) {
                System.out.print(columns);
            }
            for (int columns = rows-1; columns >=1 ; columns--) {
                System.out.print(columns);
            }
            System.out.println();
        }
    }
}
