package Exercise_3_Patterns;

public class Pattern2 {
    public static void main(String[] args) {

        for (int rows = 0; rows < 5 ; rows++) {
            for (int columns = 0; columns < 5; columns++) {
                if (rows % 2 == 0){
                    System.out.print(1);
                }else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }

    }
}
