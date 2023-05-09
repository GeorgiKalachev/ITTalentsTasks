package Lesson_3_Arrays;

public class Homework5 {
    public static void main(String[] args) {

        //Напишете програма, която създава масив с 10 елемента и
        //инициализира всеки от елементите със стойност, равна на индекса на
        //елемента, умножен по 3.
        //Да се изведат елементите на екрана.

        int[] array = new int[10];

        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3;
        }

        System.out.println();
        System.out.print("[ ");
        for (int i = 0; i < array.length; i++) {
            System.out.print((i == array.length-1) ? array[i] : array[i] + ", ");
        }
        System.out.print(" ]");


    }
}
