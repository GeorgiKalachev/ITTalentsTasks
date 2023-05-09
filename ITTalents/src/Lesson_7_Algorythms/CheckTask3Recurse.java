package Lesson_7_Algorythms;

public class CheckTask3Recurse {


    public static void main(String[] args) {

        int[] arrNums = {1, 2, 3, 4, 8, 9, 0, 23, 42, 33, 55, 56, 57, 45, 36, 3, 2, 6, 21, 31, 22, 25, 36, 34};
        int x = 55;

        summingOdd(arrNums,x);
    }

    static void summingOdd(int[] arr,int x){

        int i = arr.length-1;
        int sum = 0;

        System.out.println(summin(arr,i,sum,x));

    }

    static int summin(int[] masiv,int i, int sum,int x){

        if(i < 0){
            return sum;
        }

        if(masiv[i] > x && masiv[i] % 2 != 0){
            sum += masiv[i];
        }

        return summin(masiv,i-1,sum,x);
    }
}
