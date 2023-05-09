public class Task6 {

    public static void main(String[] args) {

        char[][] table = {
                {'h','i','v','e'},
                {'p','u','s','h'},
                {'b','u','s','h'},
                {'m','u','s','e'},
        };

        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][i] + " ");
        }

    }
}
