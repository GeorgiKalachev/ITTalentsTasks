package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        int count = 1;
        for (int rows = 1; rows <= num ; rows++) {

            for (int columns = 1; columns <= rows ; columns++) {
                if(count %2 == 1){
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
                count++;
            }

            System.out.println();
        }
    }
}
