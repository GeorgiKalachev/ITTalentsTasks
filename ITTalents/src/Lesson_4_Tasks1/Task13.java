public class Task13 {

    public static void main(String[] args) {



        int rows = 4;
        int cols = 5;

        int[][] table = new int[rows][cols];

        int number = 10;

        for (int j = 0; j < cols; j++) {
            if(j%2 == 0){
                for (int i = 0; i < rows; i++) {
                    table[i][j] = number++;
                }
            }
            else{
                for (int i = rows-1; i >= 0; i--) {
                    table[i][j] = number++;
                }
            }
        }
        //print
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

    }
}
