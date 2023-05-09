package Methods_Recursion_6;

public class Recurse1 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,-50,6,-25,8,-9};
        printingResult(arr);
    }
    static void printingResult(int[] nums){
        int i = nums.length-1;
        int sum = 0;
        sum = summingNums(nums,i,sum);
        if (sum / nums.length <= 0){
            System.out.println("Non Positive");
        }else {
            System.out.println("Positive");
        }

    }

    static int summingNums(int[] arr,int i, int sum){
        if(i == 0){
            sum += arr[i];
            return sum;
        }else {
            sum += arr[i];
            return summingNums(arr, i - 1, sum);
        }

    }
}
