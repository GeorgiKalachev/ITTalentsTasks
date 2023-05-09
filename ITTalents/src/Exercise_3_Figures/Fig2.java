package Exercise_3_Figures;

import java.util.Scanner;

public class Fig2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        for (int rows = 1; rows <= num; rows++) {
            System.out.print((rows % 2 == 0) ? " " : "");
            for (int columns = 1; columns <= num; columns++) {
                System.out.print("#");
            }
            System.out.println();
        }

    }
}
