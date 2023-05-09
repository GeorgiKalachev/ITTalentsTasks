package Homework_2;

public class Task_20 {
    public static void main(String[] args) {


        for (int i = 1; i <= 10; i++) {
            int num = i;
            if (num > 9) {
                num = 0;
            }
            for (int j = 0; j < 10; j++) {

                System.out.print(num++);
                if (num > 9) {
                    num = 0;
                }
            }
            System.out.println();
        }
    }
}
