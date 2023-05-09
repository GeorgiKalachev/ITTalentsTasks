package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се състави програма, чрез която се въвеждат два низа съдържащи
        //до 40 главни и малки букви.
        //Като резултат на екрана да се извеждат низовете само с главни и само
        //с малки букви.
        //Пример: Abcd Efgh
        //Изход: ABCD abcd EFGH efgh
        boolean isWrongSymbol = true;
        String string1;
        String string2;
        do {
            System.out.println("Enter two sentences less than 40 chars.");
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
            if (string1.length() >= 40 || string2.length() >= 40) {
                isWrongSymbol = false;
            }
        } while (!isWrongSymbol);

        System.out.println(string1.toUpperCase());
        System.out.println(string1.toLowerCase());
        System.out.println(string2.toUpperCase());
        System.out.println(string2.toLowerCase());
    }
}
