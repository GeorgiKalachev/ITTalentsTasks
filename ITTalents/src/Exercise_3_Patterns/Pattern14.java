package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern14 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int min ;

        for (int rows = 1; rows <= num; rows++) {

            for (int columns = 1; columns <=num ; columns++) {
                min = Math.min(rows, columns);
                System.out.print(num - min + 1);
            }
            System.out.println();
        }
    }
}
