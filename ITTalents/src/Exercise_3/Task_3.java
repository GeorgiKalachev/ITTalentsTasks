package Exercise_3;

import java.util.Scanner;

public class Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numA = sc.nextInt();
        int numB = sc.nextInt();

        int biggerNum;
        int smallerNum;

        if(numA > numB){
            biggerNum = numA;
            smallerNum = numB;
        }else {
            biggerNum = numB;
            smallerNum = numA;
        }

        for (int i = smallerNum; i <= biggerNum ; i++) {
            if ( i % 3 == 0){
                System.out.println(i);
            }
        }
    }
}
