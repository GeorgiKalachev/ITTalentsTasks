package consulting010823;

public class Test1Task3_1 {

    public static void main(String[] args) {

        int[] arr = {7,13,13,34,424,2,42,54,2};
        int x = 10;

        System.out.println(f(arr, 0, x, 1));
    }

    static int f(int[] arr, int i, int x, int product){
        if(i == arr.length){
            return product;
        }
        if(arr[i] > x && arr[i] % 2 == 1){
            product *= arr[i];
        }
        return f(arr, i+1, x, product);
    }
}
