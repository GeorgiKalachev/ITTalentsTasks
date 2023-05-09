package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int start;
        for (int rows = 1; rows <= num ; rows++) {
            if ( rows % 2 == 1){
                start = 1;
            }else {
                start = 2;
            }
            for (int columns = 1; columns <= rows ; columns++) {
                System.out.print(start);
                start+=2;
            }
            System.out.println();
        }
    }
}
