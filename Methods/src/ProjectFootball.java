
import java.util.*;
public class ProjectFootball {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println(" You will play football. You have to score Goal " +
                " Move the footballer through Matrix to the bottom right.");
        short difficult;
        do {
            System.out.println("Select difficult - 1-Easy ; 2-Medium ; 3-Hard ");
            difficult = sc.nextShort();
        } while (difficult <= 0 || difficult >= 4);

        short num = 10;
        short chanceDiff = 5;

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
        matrix[num - 1][num - 1] = '#';

        short x = 2;
        short y = 3;
        //topka


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
        short stepsToTarget = findShortestPathBFS(matrix);
        if(stepsToTarget < 0){
            System.out.println("Sorry you cant reach the target.");
        }else {
            System.out.println("The fastest way to target is with " + stepsToTarget + " steps.");
        }


        System.out.println("Enter commands to move footballer.");
        System.out.println("You can move only Down,Right or Up.");
        System.out.println("d = down ; r = right ; u = up");
        System.out.println("If you want to view your footballer enter - v ");


        boolean youWin = false;
        boolean youLose = false;
        char command;
        do {
            System.out.println("Enter move.");
            do {
                command = sc.next().charAt(0);
            } while (command != 'd' && command != 'r' && command != 'u' && command != 'v');
            switch (command) {
                case 'r':
                    y++;
                    if (y == num || matrix[x][y] == '*') {
                        System.out.println("You cant go right.");
                        y--;
                    }
                    break;
                case 'd':
                    x++;
                    if (x == num || matrix[x][y] == '*') {
                        System.out.println("You cant go down.");
                        x--;
                    }
                    break;
                case 'u':
                    x--;
                    if (x < 0 || matrix[x][y] == '*') {
                        System.out.println("You cant go up.");
                        x++;
                    }
                    break;
                case 'v':
                    matrix[x][y] = '@';
                    matrix[x - 2][y - 2] = 'O'; // glava
                    matrix[x - 1][y - 3] = '/'; // lqva ryka
                    matrix[x - 1][y - 2] = '|'; // tqlo
                    matrix[x - 1][y - 1] = '\\'; // dqsna ryka
                    matrix[x][y - 3] = '/'; // lqv krak
                    matrix[x][y - 1] = '\\'; // desen krak
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            System.out.print(matrix[i][j]);
                        }
                        System.out.println();
                    }
                    matrix[x][y] = ' ';
                    matrix[x - 2][y - 2] = ' '; // glava
                    matrix[x - 1][y - 3] = ' '; // lqva ryka
                    matrix[x - 1][y - 2] = ' '; // tqlo
                    matrix[x - 1][y - 1] = ' '; // dqsna ryka
                    matrix[x][y - 3] = ' '; // lqv krak
                    matrix[x][y - 1] = ' '; // desen krak
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
        } while (x < num && y < num);

        if(youWin){
            System.out.println("Congratulations!!!  You reach the target.");
        }
        if (youLose){
            System.out.println("Sorry!  GAME OVER !");
        }



    }


    private static short findShortestPathBFS(char[][] arr) {
        short startX = 2;
        short startY = 3;
        short[] moveX = new short[]{-1, 0,1};
        short[] moveY = new short[]{0, 1,0};
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        Queue<QNode> qNodes = new LinkedList<>();
        qNodes.add(new QNode(startX, startY, (short) 0));
        while (!qNodes.isEmpty()) {
            QNode currNode = qNodes.remove();
            short currX = currNode.x;
            short currY = currNode.y;
            short currDistance = currNode.distance;
            visited[currX][currY] = true;
            //System.out.println(arr[currX][currY]);
            if (arr[currX][currY] == '#') return currDistance;

            for (int i = 0; i < moveX.length; i++) {
                short newX = (short) (currX + moveX[i]);
                short newY = (short) (currY + moveY[i]);

                if (newX >= 0 && newX < arr.length && newY < arr[0].length &&
                        !visited[newX][newY] && arr[newX][newY] != '*') {
                    qNodes.add(new QNode(newX, newY, (short) (currDistance + 1)));
                }
            }


        }

        return -1;
    }

    private static class QNode {
        short x;
        short y;
        short distance;

        QNode(short x, short y, short distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

    }
}




