package Lesson_5_String_Methods;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text with digits.");
        String text = sc.nextLine();

        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(text  );
        int sum = 0;
        while (m.find()) {
            sum += Integer.parseInt(m.group());
        }
        System.out.println(sum);

    }
}
