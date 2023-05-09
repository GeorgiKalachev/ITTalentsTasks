package Lesson_3_Arrays;

import java.util.Scanner;

public class Homework12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("You have to enter 7 numbers !");
        int[] firstArr = new int[7];

        for (int i = 0; i < firstArr.length; i++) {
            System.out.println("Enter value for cell :" + (i + 1));
            firstArr[i] = sc.nextInt();

        }
        //Да се състави програма, чрез която по предварително въведени 7
        //числа в едномерен масив се разменят местата на елементи с индекси:
        //- 0 и 1 чрез трета променлива;
        //- 2 и 3 чрез събиране;
        //- 4 и 5 чрез умножение.
        //Пример: 1,2,3,4,5,6,7
        //Изход: 2,1,4,3,6,5,7


        for (int i = 0; i < firstArr.length; i++) {
            switch (i){
                case 1:
                    int temp = firstArr[i];
                    firstArr[i] = firstArr[0];
                    firstArr[0] = temp;
                    break;
                case 2:
                    firstArr[i] = firstArr[i] + firstArr[i+1];
                    break;
                case 3:
                    firstArr[i] = firstArr[i-1] - firstArr[i];
                    firstArr[i-1] -= firstArr[i];
                    break;
                case 4:
                    firstArr[i] = firstArr[i] * firstArr[i+1];
                    break;
                case 5:
                    firstArr[i] = firstArr[i-1] / firstArr[i];
                    firstArr[i-1] /= firstArr[i];
                    break;

            }
        }

        System.out.print("[ ");
        for (int i = 0; i < firstArr.length; i++) {
            System.out.print((i== firstArr.length-1) ? firstArr[i] : firstArr[i]+", ");
        }
        System.out.print(" ]");
    }
}
