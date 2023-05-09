package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task9hard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter text with digits.");
        String text = sc.nextLine();
        StringBuilder textNums= new StringBuilder();

        // asd-12sdf45-56asdf100

        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == '-' || text.charAt(i) > 47 && text.charAt(i) < 58){
                textNums.append(text.charAt(i));
                if(i != text.length()-1 && text.charAt(i+1) == '-'){
                    textNums.append(' ');
                }
                if(i != text.length()-1 ){
                    if(text.charAt(i+1) < 48 || text.charAt(i+1) > 57 ){
                        textNums.append(' ');
                    }
                }

            }
        }
        String numbers = String.valueOf(textNums);
        String[] newNums = numbers.split(" +");

        int sum = 0;
        for (int i = 0; i < newNums.length; i++) {
            sum += Integer.parseInt(newNums[i]);
        }


        System.out.println(sum);
    }
}
