package Lesson_4_Tasks1;

public class Task2 {

    public static void main(String[] args) {

        int[] arr = {1,3,2,1,4,8,6};

        boolean isJagged = true;

        for (int i = 1; i < arr.length-1; i++) {
            boolean greaterThanNeighbours = arr[i] > arr[i-1] && arr[i] > arr[i+1];
            boolean smallerThanNeighbours = arr[i] < arr[i-1] && arr[i] < arr[i+1];
            if(!( greaterThanNeighbours || smallerThanNeighbours)){
                isJagged = false;
                break;
            }
        }
        System.out.println(isJagged ? "Jagged" : "Not jagged");
    }
}
