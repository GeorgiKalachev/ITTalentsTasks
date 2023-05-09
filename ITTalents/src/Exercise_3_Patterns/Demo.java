package Exercise_3_Patterns;
import java.util.Scanner;
public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a ;
        int b ;
        a = 1;


        System.out.println(a++ + " 1");
        System.out.println(a++ + " 2");
        System.out.println(++a + " 4");
        System.out.println(a++ + " 4");
        System.out.println(a++ + " 5");
        System.out.println(a-- + " 6");
        System.out.println(a-- + " 5");
        System.out.println(--a + " 3");
        System.out.println(--a + " 2");
        System.out.println(a-- + " 2");

    }
}
