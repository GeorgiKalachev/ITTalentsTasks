public class Task8 {

    public static void main(String[] args) {

        boolean[][] table = {
                {false, true, false, true, false},
                {true, false, false, true, false},
                {false, true, false, true, false},
                {true, true, false, true, false},
                {true, true, false, true, false},
        };
        boolean exists = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if(i + j < table.length-1 && table[i][j]){
                    exists = true;
                    break;
                }
            }
        }
        System.out.println(exists);
    }
}
