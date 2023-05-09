package Lesson_5_String_Methods;

import java.util.Arrays;
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
        int ballX = 5;
        int ballY = 5;
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

        boolean[][] boolMat = new boolean[num][num];
        for (int i = 0; i < boolMat.length; i++) {
            for (int j = 0; j < boolMat[i].length; j++) {
                boolMat[i][j] = false;
            }
        }
        int steps = 0;
        steps = shortestPathToTarget(matrix,ballX,ballY,steps,boolMat);


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
            do {
                System.out.println("Enter move.");
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



    static int shortestPathToTarget(char[][] mat, int ballX, int ballY, int steps,boolean[][] boolMat) {

        if (ballX < 0 || ballY < 0 || ballX >= mat.length || ballY >= mat.length ||
                mat[ballX][ballY] == '*' || boolMat[ballX][ballY]){
            return -1;
        }


        boolean isFound = false;

        if ( mat[ballX][ballY] == '#'){

            isFound = true;
        }
        boolMat[ballX][ballY] = true;

        if ( !isFound) {
            int step1 = shortestPathToTarget(mat, ballX, ballY + 1, steps, boolMat);
            int step2 = shortestPathToTarget(mat, ballX, ballY - 1, steps, boolMat);
            int step3 = shortestPathToTarget(mat, ballX + 1, ballY, steps, boolMat);
            int step4 = shortestPathToTarget(mat, ballX - 1, ballY, steps, boolMat);

            int[] stepsArr = {step1, step2, step3, step4};

            if (step1 == -1 && step2 == -1 && step3 == -1 && step4 == -1) {
                return -1;
            } else {
                steps = step1;
                for (int i = 0; i < stepsArr.length; i++) {
                    if (stepsArr[i] != -1 && stepsArr[i] < steps) {
                        steps = stepsArr[i];
                    }
                }

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

