package Lesson_5_String_Methods;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Да се състави програма, чрез която по въведени трите имена на двама
        //човека разделени със запетая, се извежда чие име има по-голям сбор
        //от ASCII кодовете на съставящите името букви.
        //Пример: Anna Dosewa Asenowa, Iwo Peew Peew
        //Изход: Anna Dosewa Asenowa

        String[] text1 = sc.nextLine().split(",");
        int countFisrt = 0;
        int countSec = 0;
        for (int i = 0; i < text1[0].length(); i++) {
            countFisrt += text1[0].charAt(i);
        }
        for (int i = 0; i < text1[1].length(); i++) {
            countSec += text1[1].charAt(i);
        }
        if (countFisrt > countSec) {
            System.out.println(text1[0]);
        } else {
            System.out.println(text1[1]);
        }
    }
}
