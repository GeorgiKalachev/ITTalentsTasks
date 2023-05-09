package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Да се състави програма, чрез която се въвеждат 2 редици от знаци
        //(думи).
        //Ако в двете редици участва един и същи знак, да се изведе на екрана
        //първата редица хоризонтално, а втората вертикално, така че да се
        //пресичат в общия си знак.
        //Ако редиците нямат общ знак да се изведе само уведомително
        //съобщение.
        //Пример :
        //м
        //а
        //шапка
        //и
        //н
        //а

        String text1 = sc.nextLine();
        String text2 = sc.nextLine();

        int charIndex = -1;
        int charPosition = 0;
        for (int i = 0; i < text1.length(); i++) {
            if (text2.indexOf(text1.charAt(i)) != -1) {
                charIndex = i;
                charPosition = text2.indexOf(text1.charAt(i));
                break;
            }
        }
        //направих го така, за да работи със символ който може да е еднакакъв,
        // но да не е в началото на думата и пак да се пресичат.

        if (charIndex < 0) {
            System.out.println("You dont have chars that match.");
        } else {

            for (int i = 0; i < text1.length(); i++) {

                if (charIndex == i) {
                    System.out.print(text2);
                } else {
                    for (int j = 0; j < charPosition; j++) {
                        System.out.print(" ");
                    }
                    System.out.print(text1.charAt(i));
                }

                System.out.println();
            }

        }


    }
}
