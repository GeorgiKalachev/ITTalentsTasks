package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се състави програма, чрез която се въвеждат последователно две
        //редици от символи без интервали.
        //Програмата да извежда съобщение за резултата от сравнението им по
        //позиции.
        //Пример: хипопотам, хипопотук
        //Изход:
        //Двата низа са с равна дължина.
        //Разлика по позиции:
        //8 а-у
        //9 м-к

        boolean isWrongSymbol = true;
        String text1;
        String text2;
        do {
            System.out.println("Enter two sentences without space (tab).");
            text1 = sc.nextLine();
            text2 = sc.nextLine();

            for (int i = 0; i < text1.length(); i++) {
                if (text1.charAt(i) == ' ') {
                    System.out.println("Wrong symbols in text1 !");
                    isWrongSymbol = false;
                    break;
                }
            }
            for (int i = 0; i < text2.length(); i++) {
                if (text2.charAt(i) == ' ') {
                    System.out.println("Wrong symbols in text2 !");
                    isWrongSymbol = false;
                    break;
                }
            }

        } while (!isWrongSymbol);

        if (text1.length() > text2.length()) {
            System.out.println("First text is bigger.");
            printingTest(text1, text2);
        } else if (text1.length() < text2.length()) {
            System.out.println("Second text is bigger.");
            printingTest(text2, text1);
        } else {
            System.out.println("Texts are equal.");
            printingTest(text1, text2);
        }
    }

    static void printingTest(String bigText, String smallText) {
        for (int i = 0; i < smallText.length(); i++) {
            if (bigText.charAt(i) != smallText.charAt(i)) {
                System.out.println(i + " " + bigText.charAt(i) + "-" + smallText.charAt(i));
            }
        }

    }
}
