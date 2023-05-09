package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter one word.");
        String text = sc.nextLine();
        StringBuilder text2 = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char x = text.charAt(i);
            x+= 5;
            text2.append(x);
        }
        System.out.println(text2);
    }
}
