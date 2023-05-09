public class Task4 {

    public static void main(String[] args) {

        int[] arr = {1,0,1,0,1,1,0,0,1};
        //count zeroes
        int zeroes = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                zeroes++;
            }
        }
        //place 0 in the first zeroes cells
        //place 1 in the remaining cells
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i < zeroes ? 0 : 1;
        }
    }
}
