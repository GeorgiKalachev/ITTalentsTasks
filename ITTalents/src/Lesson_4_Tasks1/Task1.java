package Lesson_4_Tasks1;

public class Task1 {

    public static void main(String[] args) {

        int[] arr = {1,3,6,34,-1,5,-35,363};


        boolean allPositive = true;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 0){
                allPositive = false;
                break;
            }
        }
        System.out.println(allPositive ? "all are positive" : "not all are positive");
    }



}
