package consulting010823;

public class NastyTask {

    public static void main(String[] args) {

        int x = 3;
        int y = 3;
        int result = darkMagic(x, y);
        System.out.println(result);//27

        /*
                2^2 = 2 + 2
                2^3 = 2^2 + 2^2
                2^4 = 2^3 + 2^3

                3^2 = 3 + 3 + 3
                3^3 = 3^2 + 3^2 + 3^2

                4^2 = 4 + 4 + 4 + 4
                4^3 = 4^2 + 4^2 + 4^2 + 4^2
                -------------------------------------
                x^y = x puti subiram x^y-1
         */
    }

    static int darkMagic(int x, int y){
        if(y == 0){
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < x; i++) {
            sum += darkMagic(x, y-1);
        }
        return sum;
    }

}
