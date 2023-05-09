public class Task7 {

    public static void main(String[] args) {


        int[][] table = {
                {3,7,2,4},
                {2,1,2,4},
                {1,7,8,4},
                {9,7,2,3},
        };

        int product = 1;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if(i > j){
                    product = product * table[i][j];
                }
            }
        }
        System.out.println(product);

    }
}
