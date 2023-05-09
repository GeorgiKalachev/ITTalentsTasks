package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern16 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        for (int rows = 1; rows <= num; rows++) {
            int n = rows;
            for (int columns = rows; columns <= num ; columns++) {
                System.out.print(n++);
            }

            for (int negative = rows -1; negative >= 1 ; negative--) {
                System.out.print(negative);
            }

            System.out.println();
        }
    }
}
