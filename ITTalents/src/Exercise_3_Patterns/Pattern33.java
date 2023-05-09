package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = num; rows >= 1 ; rows--) {
            int start = rows;
            for (int columns = 1; columns <= rows ; columns++) {
                System.out.print(start++);
            }
            System.out.println();
        }
    }
}
