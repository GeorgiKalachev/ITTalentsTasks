package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        //TODO да се реши
        for (int rows = 0; rows < num ; rows++) {
            for (int columns = 0; columns < num; columns++) {

                num++;

            }
            System.out.println();
        }

    }
}
