package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] text;
        boolean textIsOk = true;


        do {
            System.out.println("Enter text with words separate with space.");
            text = sc.nextLine().split(" ");

            for (int i = 0; i < text.length; i++) {
                for (int j = 0; j < text[i].length(); j++) {

                    if (text[i].charAt(j) < 65 || text[i].charAt(j) > 90 &&
                            text[i].charAt(j) < 97 || text[i].charAt(j) > 122) {
                        System.out.println("Wrong symbols!");
                        textIsOk = false;
                        break;
                    }
                }

            }

        }while (!textIsOk);

        int words = text.length;
        int lettersInWords = text[0].length();
        for (int i = 1; i < text.length; i++) {
            for (int j = 0; j < text[i].length(); j++) {
                if (j > lettersInWords){
                    lettersInWords = j;
                }
            }
        }
        System.out.printf("There are %d words, and the biggest is with %d chars.",words,lettersInWords +1);

    }
}
