package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern23 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = 1; rows <= num ; rows++) {
            for (int column = 1; column <= rows ; column++) {
                System.out.print(num - rows + 1);
            }
            System.out.println();

        }



    }
}
