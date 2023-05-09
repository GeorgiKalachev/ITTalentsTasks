package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter string.");
        String text = sc.nextLine();

        int end = text.length()-1;
        boolean isPalindrome = true;
        for (int i = 0; i < end; i++) {
            if(text.charAt(i) != text.charAt(end)){
                isPalindrome = false;
                break;
            }
            end--;
        }

        System.out.println((isPalindrome) ? "Is Palindrome" : "Not Palindrome");






    }
}
