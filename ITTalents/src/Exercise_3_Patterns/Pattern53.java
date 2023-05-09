package Exercise_3_Patterns;

import java.util.Scanner;

public class Pattern53 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();


        while (num >= 1){
            System.out.println(num);

            num /= 10;
        }
    }
}
