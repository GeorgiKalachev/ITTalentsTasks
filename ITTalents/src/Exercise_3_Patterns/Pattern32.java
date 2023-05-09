package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = 1; rows <= num ; rows++) {
            int start = rows;
            for (int columns = 1; columns <= rows ; columns++) {
                System.out.print(start++);
            }
            System.out.println();
        }
    }
}
