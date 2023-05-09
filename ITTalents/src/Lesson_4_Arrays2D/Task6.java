package Lesson_4_Arrays2D;

public class Task6 {
    public static void main(String[] args) {

        //Имате предварително въведени стойности от естествени числа.
        //Числата са въведени в квадратна таблица с размери 6 реда и 6
        //колони.
        //Да се състави програма, чрез която се намира сумата на всички
        //елементи от редовете с четни номера: 2,4 и 6.
        //Програмата да извежда и сумата на всеки отделен ред.
        //Пример:
        int[][] matrix = {
                {11, 12, 13, 14, 15, 16},
                {21, 22, 23, 24, 25, 26},
                {31, 32, 33, 34, 35, 36},
                {41, 42, 43, 44, 45, 46},
                {51, 52, 53, 54, 55, 56},
                {61, 62, 63, 64, 65, 66},
        };

        //Изход:
        //21,22,23,24,25,26 сума 141
        //41,42,43,44,45,46 сума 261
        //61,62,63,64,65,66 сума 381
        //Сума на елементите 783
        int sumAll = 0;
        int sumColumns = 0;
        for (int i = 1; i < matrix.length; i+=2) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumColumns += matrix[i][j];
                System.out.print((j==matrix[i].length-1) ? matrix[i][j] + " sum :" + sumColumns
                        : matrix[i][j] + ",");
            }
            sumAll += sumColumns;
            sumColumns = 0;
            System.out.println();
        }
        System.out.println("sum of all elements is : " + sumAll);



    }
}
