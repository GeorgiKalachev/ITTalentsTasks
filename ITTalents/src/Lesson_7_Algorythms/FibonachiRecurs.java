package Lesson_7_Algorythms;

public class FibonachiRecurs {

    public static void main(String[] args) {

        int n = 6;

        System.out.println(fib(n));

    }

    static int fib(int n){

        if(n-1 == 1 || n-2 == 1){
            return 1;
        }
            return fib(n-1) + fib(n-2);



    }
}
