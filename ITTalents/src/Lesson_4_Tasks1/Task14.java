public class Task14 {

    public static void main(String[] args) {

        int rows = 10;
        int cols = 10;

        int[][] table = new int[rows][cols];

        int i = 0;
        int j = 0;
        int number = 10;
        int startI = 0;
        int startJ = 0;

        for (int cell = 0; cell < rows*cols; cell++) {
            table[i][j] = number++;
            i--;
            j++;
            if(i < 0 || j == cols){
                if(startI < rows-1){
                    startI++;
                }
                else{
                    startJ++;
                }
                i = startI;
                j = startJ;
            }
        }
        for (int k = 0; k < table.length; k++) {
            for (int l = 0; l < table[k].length; l++) {
                System.out.print(table[k][l] + " ");
            }
            System.out.println();
        }

    }

}
