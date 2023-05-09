public class Task9 {

    public static void main(String[] args) {


        int[][] table = {
                {8,6,1,3,5},
                {7,1,9,8,1},
                {6,2,9,7,1},
                {5,3,9,8,6},
        };
        //3 7
        //9 8

        int maxI = 0;
        int maxJ = 0;
        int maxSum = table[0][0] + table[0][1] + table[1][0] + table[1][1];
        //iterate all except last row and last column
        for (int i = 0; i < table.length - 1; i++) {
            for (int j = 0; j < table[i].length - 1; j++) {
                //sum the cell with ints right, bottom, diag
                int sum = table[i][j] + table[i][j+1] + table[i+1][j] + table[i+1][j+1];
                //find max sum
                if(sum > maxSum){
                    maxSum = sum;
                    //save the indexes of the starting cell
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        //display the starting cell with its right, bottom, diag
        System.out.println(table[maxI][maxJ] + " " + table[maxI][maxJ+1]);
        System.out.println(table[maxI+1][maxJ] + " " + table[maxI+1][maxJ+1]);







    }
}
