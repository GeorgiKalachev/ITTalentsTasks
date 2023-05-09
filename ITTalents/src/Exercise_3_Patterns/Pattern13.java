package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern13 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int n = 1;

        for (int rows = 1; rows <= num; rows++) {
            for (int columns = 1; columns <= num ; columns++) {
                System.out.print(n++ + " ");
            }
            System.out.println();
        }
    }
}
