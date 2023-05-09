package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int end = num-1;

        for (int rows = 0; rows < num ; rows++) {
            for (int columns = 0; columns < num; columns++) {
                if ( columns == rows || columns == end  ){
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }

            }
            end--;
            System.out.println();
        }

    }
}
