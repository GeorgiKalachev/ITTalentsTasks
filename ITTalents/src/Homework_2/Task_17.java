package Homework_2;

import java.util.Scanner;

public class Task_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        char ch = sc.next().charAt(0);


        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if(i > 0 && i < num-1 && j > 0 && j < num-1){
                    System.out.print(ch);
                }else {
                    System.out.print("*");
                }

            }
            System.out.println();
        }
    }

}
