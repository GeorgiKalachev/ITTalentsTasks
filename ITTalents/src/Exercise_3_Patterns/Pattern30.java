package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = num; rows >= 1 ; rows--) {
            for (int columns = rows; columns <= num ; columns++) {
                System.out.print(columns);
            }
            System.out.println();
        }
    }
}
