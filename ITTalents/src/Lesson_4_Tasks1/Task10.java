public class Task10 {

    public static void main(String[] args) {

        int[] arr = {2,5,4,4,1,1,3,2,1,2,8,5};

        int maxCounted = 0;
        int maxCounter = 0;
        for (int index = 0; index < arr.length; index++) {
            int counted = arr[index];
            int counter = 1;
            for (int i = index+1; i < arr.length; i++) {
                if(arr[i] == counted){
                    counter++;
                }
            }
            if(counter > maxCounter){
                maxCounter = counter;
                maxCounted = counted;
            }
        }
        System.out.println(maxCounted + " go ima " + maxCounter + " puti");


    }
}
