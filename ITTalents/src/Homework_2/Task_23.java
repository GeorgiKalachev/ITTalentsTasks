package Homework_2;

public class Task_23 {
    public static void main(String[] args) {

        int row = 1;


        while (row <= 9) {
            int multiply = row;
            while (multiply <= 9) {
                System.out.print(row + "*" + multiply + ";");
                multiply++;
            }

            System.out.println();
            row++;
        }
    }
}
