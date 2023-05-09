package Exercise_3_Patterns;

import java.util.Scanner;
public class Pattern51 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int start ;
        int count = 0;
        for (int rows = 1; rows <= num ; rows++) {
            if (rows % 2 == 0){
                start = count + rows;
                for (int columns = rows; columns >= 1 ; columns--) {
                    System.out.print(start + " ");
                    start--;
                    count++;
                }
            }else {
                start = count;
                for (int columns = 1; columns <= rows ; columns++) {
                    start++;
                    System.out.print(start + " ");
                    count++;
                }
            }

            System.out.println();


        }


    }
}
