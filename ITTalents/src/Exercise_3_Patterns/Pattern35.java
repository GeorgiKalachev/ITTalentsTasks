package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        for (int rows = 1; rows <= num ; rows++) {

            for (int columns = 1; columns <= rows ; columns++) {
                if(columns%2 == 1){
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
            }

            System.out.println();
        }
    }

}
