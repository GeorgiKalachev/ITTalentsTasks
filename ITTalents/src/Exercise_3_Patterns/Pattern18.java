package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern18 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int min ;

        for (int rows = 1; rows <= num; rows++) {
            // първа част като зад.14 ( горен ляв ъгъл )
            for (int columns = 1; columns <=num ; columns++) {
                min = Math.min(rows, columns);
                System.out.print(num - min + 1);
            }
            // втора част ( горен десен ъгъл )
            for ( int columns = num - 1; columns >= 1; columns--)
            {
                min = Math.min(rows, columns);
                System.out.print(num - min + 1);
            }
            System.out.println();
        }

        // трета част ( отдоло по същия начин )
        for ( int rows = num - 1; rows >= 1; rows--)
        {
            for (int columns = 1; columns <= num; columns++)
            {
                min = Math.min(rows, columns);
                System.out.print(num - min + 1);
            }
            for (int columns = num - 1; columns >= 1; columns--)
            {
                min = Math.min(rows, columns);
                System.out.print(num - min + 1);
            }
            System.out.println();
        }
    }
}
