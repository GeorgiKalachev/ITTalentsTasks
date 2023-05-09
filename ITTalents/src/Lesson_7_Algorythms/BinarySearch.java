package Lesson_7_Algorythms;

public class BinarySearch {
    public static void main(String[] args) {


        int[] masiv = {2,3,4,5,6,7,8,9,10,11,12,13,14,15,17,18,19,20};

        int end = masiv.length-1;
        int start = 0;

        int x = 17;

        System.out.println(findingX(masiv,start,end,x));
    }

    static int findingX(int[] masiv, int start, int end, int x){

        if ( start > end){
            return -1;
        }
        int middle = (start + end) / 2;

        if(masiv[middle] == x){
            return middle;
        }

        if ( masiv[middle] > x){
            return findingX(masiv,start,middle-1,x);
        }else {
            return findingX(masiv, middle+1,end, x);
        }






    }
}
