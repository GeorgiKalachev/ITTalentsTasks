public class Task5 {

    public static void main(String[] args) {

        /*
            3,7,2,4,5 //21
            2,1,2,4,2 //11
            0,7,8,4,1 //20
            9,7,2,3,8 //29
            ---------
            9 7 2 3 8
         */

        int[][] table = {
                {3,7,2,4,5},
                {2,1,2,4,2},
                {0,7,8,4,1},
                {9,7,2,3,8},
        };

        int maxSum = 0;
        int maxRowIdx = 0;
        for (int row = 0; row < table.length; row++) {
            int sum = 0;
            for (int i = 0; i < table[row].length; i++) {
                sum += table[row][i];
            }
            if(maxSum < sum){
                maxSum = sum;
                maxRowIdx = row;
            }
        }
        for (int i = 0; i < table[maxRowIdx].length; i++) {
            System.out.print(table[maxRowIdx][i] + " ");
        }
    }
}
