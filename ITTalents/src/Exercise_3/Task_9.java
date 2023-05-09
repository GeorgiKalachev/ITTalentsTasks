package Exercise_3;

import java.util.Random;
import java.util.Scanner;

public class Task_9 {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        //Modify task 8 to print a triangle that is hollow and has only a frame of stars.
        // *
        int num = sc.nextInt();

        for (int rows = 0; rows < num; rows++) {

            for (int empty = num - rows; empty > 1; empty--) {
                System.out.print(" ");
            }
            for (int stars = 0; stars <= rows; stars++) {
                // проверка да принти звезда само в края
                if (rows < num - 1 && stars > 0 && stars < rows) {

                    Random r = new Random();
                    int chance = r.nextInt(100);
                    char randomCharIndex = (char) r.nextInt(5000);
                    if (chance < 20){
                        System.out.print(randomCharIndex + " ");
                    }else {
                        System.out.print(" ");
                    }

                } else {
                    System.out.print("* ");
                }
            }

            System.out.println();
        }
    }
}
