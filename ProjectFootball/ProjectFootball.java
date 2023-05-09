package Lesson_4_Tasks1;

import java.util.*;
public class ProjectFootball {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println(" You will play football. You have to score Goal " +
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
        matrix[num - 1][num - 1] = '#'; // врата
        int[] ball = {4,4}; // topka
        int[] rightFoot = {3,3}; // desen krak

        matrix[ball[0]][ball[1]] = '@';
        matrix[rightFoot[0] - 2][rightFoot[1] - 1] = 'O'; // glava
        matrix[rightFoot[0] - 1][rightFoot[1] - 2] = '/'; // lqva ryka
        matrix[rightFoot[0] - 1][rightFoot[1] - 1] = '|'; // tqlo
        matrix[rightFoot[0] - 1][rightFoot[1] ] = '\\'; // dqsna ryka
        matrix[rightFoot[0]][rightFoot[1] - 2] = '/'; // lqv krak
        matrix[rightFoot[0]][rightFoot[1]] = '\\'; // desen krak


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    Random r = new Random();
                    int chance = r.nextInt(100);
                    if (chance < chanceDiff) {
                        matrix[i][j] = '*';
                    } else {
                        matrix[i][j] = ' ';
                    }
                }
            }
        }

        // Имаме футболист, игрище и трудност
        int stepsToTarget = findShortestPathBFS(matrix);
        if(stepsToTarget < 0){
            System.out.println("Sorry you cant reach the target.");
        }else {
            System.out.println("The fastest way to target is in " + stepsToTarget + " steps.");
        }


        System.out.println("Enter commands to move footballer.");
        System.out.println("You can move Left,,Right,Down or Up.");
        System.out.println("l = left ; d = down ; r = right ; u = up");
        System.out.println("If you want to view your footballer enter - v ");


        boolean youWin = false;
        boolean youLose = false;
        char command;
        do {
            printingMatrix(matrix,rightFoot,ball);
            System.out.println("Enter move.");
            do {
                command = sc.next().charAt(0);
            } while (command != 'l' && command != 'd' && command != 'r' && command != 'u' && command != 'v');
            boolean foundBall = false;
            switch (command) {
                case 'l':
                    if(rightFoot[1] >= 3) {
                        rightFoot[1]--;

                    }else {
                        rightFoot[1]++;
                    }


                    if(checkingPlayerMove(matrix,rightFoot,command,num)){

                        if (checkIfCanPushBall(matrix,rightFoot,command,num)){
                            ball[1]--;
                        }
                    }
                    break;
                case 'r':
                    if(checkingPlayerMove(matrix,rightFoot,command,num)){
                        rightFoot[1]++;
                        if (checkIfCanPushBall(matrix,rightFoot,command,num)){
                            ball[1]++;
                        }
                    }
                    break;
                case 'd':
                    if(checkingPlayerMove(matrix,rightFoot,command,num)){
                        rightFoot[0]--;
                        if (checkIfCanPushBall(matrix,rightFoot,command,num)){
                            ball[0]--;
                        }
                    }
                    break;
                case 'u':
                    if(checkingPlayerMove(matrix,rightFoot,command,num)){
                        rightFoot[0]++;
                        if (checkIfCanPushBall(matrix,rightFoot,command,num)){
                            ball[0]++;
                        }
                    }
                    break;

            }

            if(matrix[x-1][y] == '*' && matrix[x+1][y] == '*' && matrix[x][y+1] == '*' ||
                 x == num -1 && matrix[x-1][y] == '*' && matrix[x][y+1] == '*' ||
                 y == num-1 && matrix[x-1][y] == '*' && matrix[x+1][y] == '*' ){
                youLose = true;
                break;
            }
            if (x == num - 1 && y == num - 1) {
                youWin = true;
                break;
            }
        } while (rightFoot[0] < num && rightFoot[1] < num);

        if(youWin){
            System.out.println("Congratulations!!!  You reach the target.");
        }
        if (youLose){
            System.out.println("Sorry!  GAME OVER !");
        }



    }

    static boolean shootingTheBall (char[][] mat) {

        String chars = "O?"

    }

    static void printingMatrix(char[][] matrix, int[] rightFoot,int[]ball){
        matrix[ball[0]][ball[1]] = '@';
        matrix[rightFoot[0] - 2][rightFoot[1] - 1] = 'O'; // glava
        matrix[rightFoot[0] - 1][rightFoot[1] - 2] = '/'; // lqva ryka
        matrix[rightFoot[0] - 1][rightFoot[1] - 1] = '|'; // tqlo
        matrix[rightFoot[0] - 1][rightFoot[1] ] = '\\'; // dqsna ryka
        matrix[rightFoot[0]][rightFoot[1] - 2] = '/'; // lqv krak
        matrix[rightFoot[0]][rightFoot[1]] = '\\'; // desen krak
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        matrix[ball[0]][ball[1]] = ' ';
        matrix[rightFoot[0] - 2][rightFoot[1] - 1] = ' '; // glava
        matrix[rightFoot[0] - 1][rightFoot[1] - 2] = ' '; // lqva ryka
        matrix[rightFoot[0] - 1][rightFoot[1] - 1] = ' '; // tqlo
        matrix[rightFoot[0] - 1][rightFoot[1]] = ' '; // dqsna ryka
        matrix[rightFoot[0]][rightFoot[1] - 2] = ' '; // lqv krak
        matrix[rightFoot[0]][rightFoot[1]] = ' '; // desen krak
    }
    static boolean checkIfCanPushBall(char[][] mat, int[] foot,char ch,int num) {
        switch (ch) {
            case 'l':
                if (foot[1] >= 4 && mat[foot[0]][foot[1] - 3] == '@' && mat[foot[0]][foot[1] - 4] != '*' ||
                        foot[1] >= 4 && mat[foot[0] - 1][foot[1] - 3] == '@' && mat[foot[0] - 1][foot[1] - 4] != '*' ||
                        foot[1] >= 4 && mat[foot[0] - 2][foot[1] - 3] == '@' && mat[foot[0] - 2][foot[1] - 4] != '*') {
                    return true;
                } else {
                    return false;
                }
            case 'd':
                if (foot[0] <= num - 3 && mat[foot[0] + 1][foot[1]] == '@' && mat[foot[0] + 2][foot[1]] != '*' ||
                        foot[0] <= num - 3 && mat[foot[0] + 1][foot[1] - 1] != '@' && mat[foot[0] + 2][foot[1] - 1] != '*' ||
                        foot[0] <= num - 3 && mat[foot[0] + 1][foot[1] - 2] != '@' && mat[foot[0] + 2][foot[1] - 2] != '*') {
                    return true;
                } else {
                    return false;
                }
            case 'u':
                if (foot[0] >= 4 && mat[foot[0] + 3][foot[1] - 2] == '@' && mat[foot[0] + 4][foot[1] - 2] != '*' ||
                        foot[0] >= 4 && mat[foot[0] + 3][foot[1] - 1] == '@' && mat[foot[0] + 4][foot[1] - 1] != '*' ||
                        foot[0] >= 4 && mat[foot[0] + 3][foot[1]] == '@' && mat[foot[0] + 3][foot[1]] != '*') {
                    return true;
                } else {
                    return false;
                }
            case 'r':
                if (foot[1] <= num - 3 && mat[foot[0]][foot[1] + 1] == '@' && mat[foot[0]][foot[1] + 2] == '*' ||
                        foot[1] <= num - 3 && mat[foot[0] - 1][foot[1] + 1] == '@' && mat[foot[0] - 1][foot[1] + 2] == '*' ||
                        foot[1] <= num - 3 && mat[foot[0] - 2][foot[1] + 1] == '@' && mat[foot[0] - 2][foot[1] + 2] == '*') {
                    return true;
                } else {
                    return false;
                }

        }

        return false;
    }
    static boolean checkingPlayerMove(char[][] mat, int[] foot,char ch,int num){



                if(foot[1] >= 3 || mat[foot[0]][foot[1]-3] == '@' && mat[foot[0]][foot[1]-4] == '*' ||
                        mat[foot[0]-1][foot[1]-3] == '@' && mat[foot[0]-1][foot[1]-4] == '*'||
                        mat[foot[0]-2][foot[1]-3] == '@' && mat[foot[0]-2][foot[1]-4] == '*'){
                    return false;
                }else {
                    return true;
                }
                break;
            case 'd':
                if(foot[0] >= num-1 || mat[foot[0]+1][foot[1]] == '@' && mat[foot[0]+2][foot[1]] == '*' ||
                        mat[foot[0]+1][foot[1]-1] == '@' && mat[foot[0]+2][foot[1]-1] == '*'
                        || mat[foot[0]+1][foot[1]-2] == '@' && mat[foot[0]+2][foot[1]-2] == '*'){
                    return false;
                 }else {
                    return true;
                }
                break;
            case 'u':
                if(foot[0] <= 2 || mat[foot[0]+3][foot[1]-2] == '@' && mat[foot[0]+4][foot[1]-2] =='*' ||
                        mat[foot[0]+3][foot[1]-1] == '@' && mat[foot[0]+4][foot[1]-1] == '*' ||
                        mat[foot[0]+3][foot[1]] == '@' && mat[foot[0]+3][foot[1]] == '*' ){
                    return false;
                }else {
                    return true;
                }
                break;
            case 'r':
                if (foot[1] >= num-1 || mat[foot[0]][foot[1]+1] == '@' && mat[foot[0]][foot[1]+2] == '*'
                || mat[foot[0]-1][foot[1]+1] == '@' && mat[foot[0]-1][foot[1]+2] == '*' ||
                        mat[foot[0]-2][foot[1]+1] == '@' && mat[foot[0]-2][foot[1]+2] == '*') {
                    return false;
                }else {
                    return true;
                }
                break;
        }




    }


    private static int findShortestPathBFS(char[][] arr) {
        int startX = 2;
        int startY = 3;
        int[] moveX = new int[]{-1, 0,1};
        int[] moveY = new int[]{0, 1,0};
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        Queue<QNode> qNodes = new LinkedList<>();
        qNodes.add(new QNode(startX, startY, 0));
        while (!qNodes.isEmpty()) {
            QNode currNode = qNodes.remove();
            int currX = currNode.x;
            int currY = currNode.y;
            int currDistance = currNode.distance;
            visited[currX][currY] = true;
            //System.out.println(arr[currX][currY]);
            if (arr[currX][currY] == '#') return currDistance;

            for (int i = 0; i < moveX.length; i++) {
                int newX = currX + moveX[i];
                int newY = currY + moveY[i];

                if (newX >= 0 && newX < arr.length && newY < arr[0].length &&
                        !visited[newX][newY] && arr[newX][newY] != '*') {
                    qNodes.add(new QNode(newX, newY, currDistance + 1));
                }
            }


        }

        return -1;
    }

    private static class QNode {
        int x;
        int y;
        int distance;

        QNode(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }
}




