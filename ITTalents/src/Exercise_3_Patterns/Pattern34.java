package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern34 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = 1; rows <= num * 2 ; rows+=2) {

            for (int columns = rows; columns <= num * 2 ; columns+= 2) {
                System.out.print(columns);

            }

            System.out.println();
        }
    }
}
