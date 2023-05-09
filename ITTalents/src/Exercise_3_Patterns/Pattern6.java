package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        for (int rows = 0; rows < num ; rows++) {
            for (int columns = 0; columns < num; columns++) {
               if ( (rows + columns) % 2 == 0){
                   System.out.print(1);
               }else {
                   System.out.print(0);
               }
            }
            System.out.println();
        }

    }
}
