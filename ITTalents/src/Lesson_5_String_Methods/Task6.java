package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Да се състави програма, чрез която се въвежда изречение с отделни
        //думи.
        //Като резултат на екрана да се извежда същия текст, но всяка отделна
        //дума да започва с главна буква, а следващите я букви да са малки.
        //Пример: супер яката задача
        //Изход: Супер Яката Задача
        String text;
        boolean textIsOk = true;

        do {
            System.out.println("Enter text with words separate with space.");
            text = sc.nextLine();

            for (int i = 0; i < text.length(); i++) {
                if(text.charAt(i) == ' '){
                    continue;
                }
                    if ( text.charAt(i) < 65 || text.charAt(i) > 90 &&
                            text.charAt(i) < 97 || text.charAt(i) > 122 ) {
                        System.out.println("Wrong symbols!");
                        textIsOk = false;
                        break;
                    }

            }

        }while (!textIsOk);

        char[] charArray = text.toCharArray();
        boolean foundSpace = true;

        for(int i = 0; i < charArray.length; i++) {

            if(Character.isLetter(charArray[i])) {

                if(foundSpace) {

                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }else {
                    charArray[i] = Character.toLowerCase(charArray[i]);
                }
            }

            else {
                foundSpace = true;
            }
        }
        text = String.valueOf(charArray);
        System.out.println(text);


        }
    }

