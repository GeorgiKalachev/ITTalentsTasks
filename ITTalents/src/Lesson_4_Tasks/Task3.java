package Lesson_4_Tasks;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Напишете програма, която за даден масив от символи arr и
        //символ ch, въведен от потребителя, проверява али arr съдържа
        //ch. Ако се съдържа, отпечатайте индекса на елемента. Ако не,
        //отпечатайте подходящо избрана от вас стойност.
        int num = sc.nextInt();

        char[] charsArr = new char[num];

        for (int i = 0; i < charsArr.length; i++) {
            System.out.println("Enter char :");
            charsArr[i] = sc.next().charAt(0);
        }
        char enterChar;
        boolean hasChar = true;
        do {
            System.out.println("Enter char to look for :");
            enterChar = sc.next().charAt(0);
            for (int i = 0; i < charsArr.length; i++) {
                if (charsArr[i] != enterChar){
                    hasChar = false;
                    System.out.println("Doesnt have that char.");
                    break;
                }else {
                    System.out.println("Has that char at index : "+ (i+1));
                }
            }

        }while (!hasChar);
    }
}
