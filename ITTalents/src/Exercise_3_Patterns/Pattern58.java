package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern58 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        //  Първи цикъл до средата.Всеки ред започваме със звезда
        for (int rows = 0; rows <= num ; rows++) {
            System.out.print("*");

            // първи цикъл започва след първия ред
            for (int columns = 1; columns <=rows ; columns++) {
                System.out.print(columns);
            }
            // втори цикъл в обратен ред
            for (int columns = rows-1; columns >=1 ; columns--) {
                System.out.print(columns);
            }
            // ако е в края "*" с тернарен оператор !
            System.out.print((rows>=1)? "*":"");
            System.out.println();
        }



        for (int rows = num ; rows >= 1 ; rows--) {
            System.out.print("*");

            for (int columns = 1; columns <= rows-1 ; columns++) {
                System.out.print(columns);
            }
            for (int columns = rows-2; columns >=1 ; columns--) {
                System.out.print(columns);
            }
            System.out.print((rows>1)? "*":"");
            System.out.println();
        }


    }
}
