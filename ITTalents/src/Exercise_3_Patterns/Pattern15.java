package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern15 {
    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        for (int rows = 1; rows <= num; rows++) {
            int n = rows;
            for (int columns = 1; columns <= num ; columns++) {
                System.out.print(n);
                if ( n < num){
                    n++;
                }
            }
            System.out.println();
        }
    }
}
