package consulting010823;

public class Test1Task3 {

    public static void main(String[] args) {

        int[] arr = {1,6,3,8,2};
        f(arr, 0, 0);

    }

    static String f(int[] arr, int i, int sum){
        if(i == arr.length){
            return sum / arr.length > 0 ? "Positive" : "Negative";
        }
        sum += arr[i];
        return f(arr, i+1, sum);
    }

}
