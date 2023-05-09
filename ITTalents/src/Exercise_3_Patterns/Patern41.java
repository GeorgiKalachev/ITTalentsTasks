package Exercise_3_Patterns;

import java.util.Scanner;

public class Patern41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        for (int rows = 1; rows <= num ; rows++) {

            for (int columns = 1; columns <= rows*2-1 ; columns+=2) {
                System.out.print(columns);

            }
            for (int columns = rows*2-3; columns >= 1 ; columns-=2) {
                System.out.print(columns);
            }
            System.out.println();
        }
    }
}
