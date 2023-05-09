package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int middle = num / 2;

        for (int rows = 0; rows < num ; rows++) {
            for (int columns = 0; columns < num; columns++) {
               if ( rows == middle && columns == middle){
                   System.out.print(0);
               }else {
                   System.out.print(1);
               }

            }
            System.out.println();
        }

    }
}
