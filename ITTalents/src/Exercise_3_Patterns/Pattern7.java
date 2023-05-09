package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();



        for (int rows = 0; rows < num ; rows++) {
            for (int columns = 0; columns < num; columns++) {
                if ( rows == num / 2 || columns == num / 2){
                    System.out.print(0);
                }else {
                    System.out.print(1);
                }

            }
            System.out.println();
        }

    }
}
