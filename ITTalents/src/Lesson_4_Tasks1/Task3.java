import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        char[] symbols = {'f','g','4','~','!'};
        char ch = 'f';
        int index = -1;
        for (int i = 0; i < symbols.length; i++) {
            if(symbols[i] == ch){
                index = i;
                break;
            }
        }
        System.out.println(index);

    }
}
