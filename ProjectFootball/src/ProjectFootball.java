
import java.util.Random;
import java.util.Scanner;

public class ProjectFootball {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" You will play football. You have to score Goal in #.\n " +
                " Move the footballer through Matrix to the bottom right.");
        int difficult;
        do {
            System.out.println("Select difficult - 1-Easy ; 2-Medium ; 3-Hard ");
            difficult = sc.nextInt();
        } while (difficult <= 0 || difficult >= 4);

        int num = 10;
        int chanceDiff = 5;
        switch (difficult) {
            case 2:
                num = 20;
                chanceDiff = 10;
                break;
            case 3:
                num = 30;
                chanceDiff = 20;
                break;
        }

        char[][] matrix = new char[num][num];

        int[] ball = {5, 5}; // ball
        int ballX = num - 1;
        int ballY = num - 1;
        int[] rightFoot = {3, 3}; // right foot

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = '_';
                Random r = new Random();
                int chance = r.nextInt(100);
                if (chance <= chanceDiff) {
                    matrix[i][j] = '*';
                }
            }
        }


        // Имаме футболист, игрище и трудност


        int steps = shortestPathToTarget(matrix,ballX,ballY,steps);


        if (steps > 0) {
            System.out.println("The shortest path to target is in : " + steps + " steps.");
         } else {
             System.out.println("You dont have path to target.\n" +
                   "Sorry Game Over !");

        }

        System.out.println("Enter commands to move footballer.");
        System.out.println("You can move Left,,Right,Down or Up.");
        System.out.println("a = left ; s = down ; d = right ; w = up");
        System.out.println("If you cant move the ball 5 times = you LOSE !!! ");


        boolean youWin = false;
        int counterCantMove = 0;
        char command;

        do {
            printingMatrix(matrix, rightFoot, ball);

            System.out.println("Enter move.");
            do {
                command = sc.next().charAt(0);
            } while (command != 'a' && command != 'd' && command != 'w' && command != 's');

            switch (command) {
                case 'a':
                    if (rightFoot[1] >= 3) {
                        rightFoot[1]--;
                        if (pushingTheBall(ball, rightFoot)) {
                            ball[1]--;
                            if (!checkingIfCanMove(matrix, ball)) {
                                rightFoot[1]++;
                                ball[1]++;
                                System.out.println("You cant move the ball left.");
                                counterCantMove++;
                            }

                        }


                    } else {
                        System.out.println("You cant move left.");
                    }
                    break;
                case 'd':
                    if (rightFoot[1] < matrix.length - 1) {
                        rightFoot[1]++;
                        if (pushingTheBall(ball, rightFoot)) {
                            ball[1]++;
                            if (!checkingIfCanMove(matrix, ball)) {
                                rightFoot[1]--;
                                ball[1]--;
                                System.out.println("You cant move the ball right.");
                                counterCantMove++;
                            }
                        }

                    } else {
                        System.out.println("You cant move right.");
                    }
                    break;
                case 'w':
                    if (rightFoot[0] >= 3) {
                        rightFoot[0]--;
                        if (pushingTheBall(ball, rightFoot)) {
                            ball[0]--;
                            if (!checkingIfCanMove(matrix, ball)) {
                                rightFoot[0]++;
                                ball[0]++;
                                System.out.println("You cant move the ball up.");
                                counterCantMove++;
                            }
                        }

                    } else {
                        System.out.println("You cant move up.");
                    }
                    break;
                case 's':
                    if (rightFoot[0] < matrix.length - 1) {
                        rightFoot[0]++;
                        if (pushingTheBall(ball, rightFoot)) {
                            ball[0]++;
                            if (!checkingIfCanMove(matrix, ball)) {
                                rightFoot[0]--;
                                ball[0]--;
                                System.out.println("You cant move the ball down.");
                                counterCantMove++;
                            }
                        }

                    } else {
                        System.out.println("You cant move down.");
                    }
                    break;
            }

            if (ball[0] == num - 1 && ball[1] == num - 1) {
                youWin = true;
                break;
            }

            if (loosingTheGame(matrix, ball) || counterCantMove == 5) {
                System.out.println("Sorry!  GAME OVER !");
                break;
            }

        } while (rightFoot[0] < num && rightFoot[1] < num);

        if (youWin) {
            System.out.println("Congratulations!!!  You reach the target.");
        }


    }


    static int shortestPathToTarget(char[][] mat, int ballX, int ballY, int steps) {
        steps++;

        int step1 = 0;
        int step2 = 0;
        int step3 = 0;
        int step4 = 0;
        boolean isFound = false;
        if (ballX >= 1 && ballX <= mat.length - 2 && ballY <= mat.length - 2 && ballY >= 1) {
            if (mat[ballX][ballY - 1] == '#') {
                steps = step1;
                isFound = true;
            }
            if (mat[ballX][ballY - 1] == '_' && ballX - 1 > 0 && ballY + 1 <= mat.length - 1
                    && ballY - 1 > 0 && ballY + 1 < mat.length - 1) {
                step1 = shortestPathToTarget(mat, ballX, ballY - 1, steps);
            }
        }
        if (ballX >= 1 && ballX <= mat.length - 2 && ballY <= mat.length - 2 && ballY >= 1) {
            if (mat[ballX][ballY + 1] == '#') {
                steps = step2;
                isFound = true;
            }
            if (mat[ballX][ballY + 1] == '_' && ballX - 1 > 0 && ballY + 1 < mat.length - 1
                    && ballY - 1 > 0 && ballY + 1 <= mat.length - 1) {
                step2 = shortestPathToTarget(mat, ballX, ballY + 1, steps);
            }
        }
        if (ballX <= mat.length - 2 && ballY <= mat.length - 2 && ballX >= 1 && ballY >= 1) {
            if (mat[ballX - 1][ballY] == '#') {
                steps = step3;
                isFound = true;
            }
            if (mat[ballX - 1][ballY] == '_' && ballX - 1 > 0 && ballY + 1 < mat.length - 1
                    && ballY - 1 > 0 && ballY + 1 < mat.length - 1) {
                step3 = shortestPathToTarget(mat, ballX + 1, ballY, steps);
            }
        }
        if (ballX <= mat.length - 2 && ballY <= mat.length - 2 && ballX >= 1 && ballY >= 1) {
            if (mat[ballX - 1][ballY] == '#') {
                steps = step4;
                isFound = true;
            }
            if (mat[ballX - 1][ballY] == '_' && ballX - 1 > 0 && ballY + 1 <= mat.length - 1
                    && ballY - 1 > 0 && ballY + 1 <= mat.length - 1) {
                step4 = shortestPathToTarget(mat, ballX - 1, ballY, steps);
            }
        }

        return steps;
    }


    static boolean checkingIfCanMove(char[][] mat, int[] ball) {
        return ball[0] >= 0 && ball[0] <= mat.length - 1 &
                ball[1] >= 0 && ball[1] <= mat.length - 1 && mat[ball[0]][ball[1]] != '*';
    }

    static boolean pushingTheBall(int[] ball, int[] foot) {

        int ballX = ball[0];
        int ballY = ball[1];
        int footX = foot[0];
        int footY = foot[1];

        // tqloto
        int[] moveX = {0, 0, -1, -1, -2, -1};
        int[] moveY = {0, -2, 0, -2, -1, -1};

        for (int i = 0; i < moveX.length; i++) {
            int currX = footX + moveX[i];
            int currY = footY + moveY[i];
            if (ballX == currX && ballY == currY) {
                return true;
            }
        }
        return false;
    }


    static boolean loosingTheGame(char[][] mat, int[] ball) {

        int ballX = ball[0];
        int ballY = ball[1];

        return ballY == 0 || ballX == 0 || ballY == mat.length - 1 && ballX + 1 == '*' ||
                ballY == mat.length - 1 && ballX - 1 == '*' ||
                ballX == mat.length - 1 && ballY + 1 == '*' ||
                ballX == mat.length - 1 && ballY - 1 == '*';
    }

    static void printingMatrix(char[][] matrix, int[] rightFoot, int[] ball) {

        matrix[matrix.length - 1][matrix.length - 1] = '#'; // footballDoor
        matrix[ball[0]][ball[1]] = '@';
        if (matrix[rightFoot[0] - 2][rightFoot[1] - 1] == '*') {
            matrix[rightFoot[0] - 2][rightFoot[1] - 1] = '*';
        } else {
            matrix[rightFoot[0] - 2][rightFoot[1] - 1] = 'O'; // Head
        }
        if (matrix[rightFoot[0] - 1][rightFoot[1] - 2] == '*') {
            matrix[rightFoot[0] - 1][rightFoot[1] - 2] = '*';
        } else {
            matrix[rightFoot[0] - 1][rightFoot[1] - 2] = '/'; // left hand
        }
        if (matrix[rightFoot[0] - 1][rightFoot[1] - 1] == '*') {
            matrix[rightFoot[0] - 1][rightFoot[1] - 1] = '*';
        } else {
            matrix[rightFoot[0] - 1][rightFoot[1] - 1] = '|'; // body
        }
        if (matrix[rightFoot[0] - 1][rightFoot[1]] == '*') {
            matrix[rightFoot[0] - 1][rightFoot[1]] = '*';
        } else {
            matrix[rightFoot[0] - 1][rightFoot[1]] = '\\'; // right hand
        }
        if (matrix[rightFoot[0]][rightFoot[1] - 2] == '*') {
            matrix[rightFoot[0]][rightFoot[1] - 2] = '*';
        } else {
            matrix[rightFoot[0]][rightFoot[1] - 2] = '/'; // left foot
        }
        if (matrix[rightFoot[0]][rightFoot[1]] == '*') {
            matrix[rightFoot[0]][rightFoot[1]] = '*';
        } else {
            matrix[rightFoot[0]][rightFoot[1]] = '\\'; // right foot
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

        matrix[ball[0]][ball[1]] = '@';
        if (matrix[rightFoot[0] - 2][rightFoot[1] - 1] == '*') {
            matrix[rightFoot[0] - 2][rightFoot[1] - 1] = '*';
        } else {
            matrix[rightFoot[0] - 2][rightFoot[1] - 1] = '_'; // Head
        }
        if (matrix[rightFoot[0] - 1][rightFoot[1] - 2] == '*') {
            matrix[rightFoot[0] - 1][rightFoot[1] - 2] = '*';
        } else {
            matrix[rightFoot[0] - 1][rightFoot[1] - 2] = '_'; // left hand
        }
        if (matrix[rightFoot[0] - 1][rightFoot[1] - 1] == '*') {
            matrix[rightFoot[0] - 1][rightFoot[1] - 1] = '*';
        } else {
            matrix[rightFoot[0] - 1][rightFoot[1] - 1] = '_'; // body
        }
        if (matrix[rightFoot[0] - 1][rightFoot[1]] == '*') {
            matrix[rightFoot[0] - 1][rightFoot[1]] = '*';
        } else {
            matrix[rightFoot[0] - 1][rightFoot[1]] = '_'; // right hand
        }
        if (matrix[rightFoot[0]][rightFoot[1] - 2] == '*') {
            matrix[rightFoot[0]][rightFoot[1] - 2] = '*';
        } else {
            matrix[rightFoot[0]][rightFoot[1] - 2] = '_'; // left foot
        }
        if (matrix[rightFoot[0]][rightFoot[1]] == '*') {
            matrix[rightFoot[0]][rightFoot[1]] = '*';
        } else {
            matrix[rightFoot[0]][rightFoot[1]] = '_'; // right foot
        }

    }

}

