package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се състави програма, чрез която от клавиатурата се въвеждат
        //последователно две думи с дължина 10-20 знака.
        //Програмата да размени първите им 5 знака и да изведе дължината на
        //по-дългата, както и новото им съдържание.
        //Пример: uchilishe uchenik
        //Изход: 9 uchenishe

        boolean isWrongSymbol = true;
        String string1;
        String string2;
        do {
            System.out.println("Enter two sentences less than 20 chars.");
            string1 = sc.nextLine();
            string2 = sc.nextLine();

            for (int i = 0; i < string1.length(); i++) {
                if (string1.charAt(i) < 65 || string1.charAt(i) > 90 &&
                        string1.charAt(i) < 97 || string1.charAt(i) > 122) {
                    System.out.println("Wrong symbols!");
                    isWrongSymbol = false;
                    break;
                }
            }
            for (int i = 0; i < string2.length(); i++) {
                if (string2.charAt(i) < 65 || string2.charAt(i) > 90 &&
                        string2.charAt(i) < 97 || string2.charAt(i) > 122) {
                    System.out.println("Wrong symbols!");
                    isWrongSymbol = false;
                    break;
                }
            }
            if (string1.length() > 20 || string2.length() > 20) {
                isWrongSymbol = false;
            }
        } while (!isWrongSymbol);

        if (string1.length() > string2.length()) {
            System.out.print(string1.length());
            System.out.println(" " + string2.substring(0, 5).concat(string1.substring(5)));
        } else {
            System.out.print(string2.length());
            System.out.println(" " + string1.substring(0, 5).concat(string2.substring(5)));
        }
    }

}
