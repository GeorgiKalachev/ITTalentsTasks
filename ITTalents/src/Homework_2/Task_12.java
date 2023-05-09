package Homework_2;

public class Task_12 {
    public static void main(String[] args) {

        for (int i = 100; i <= 999; i++) {

            int firstDig = i / 100;
            int secDig = (i % 100) / 10;
            int thirdDIg = i % 10;

            if (firstDig != secDig && firstDig != thirdDIg && secDig != thirdDIg) {
                System.out.println(i);
            }
        }

    }

}
