package consulting010823;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        char[][] board = new char[3][5];
        generateBoard(board);
        while (true) {
            placeMove(board, 'X');
            printBoard(board);
            if(isGameOver(board)){
                break;
            }
            placeMoveAI(board, 'O');
            printBoard(board);
            if(isGameOver(board)){
                break;
            }
        }
    }

    static boolean isGameOver(char[][] board){
        int victory = checkVictory(board);
        if(victory > 0){
            System.out.println("Game over");
            System.out.println("Player " + victory + " WINS!");
            return true;
        }
        else{
            if(draw(board)){
                System.out.println("Game over with no winner");
                return true;
            }
        }
        return false;
    }

    static boolean draw(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    static int checkVictory(char[][] board){
        //return 1 if X is victorious
        //return 2 if O is victorious
        //return 0 if no winner yet
        //CHECK ROWS
        if(board[0][0] == board[0][2] && board[0][2] == board[0][4] && board[0][0] != ' '){
            return board[0][0] == 'X' ? 1 : 2;
        }
        if(board[1][0] == board[1][2] && board[1][2] == board[1][4] && board[1][0] != ' '){
            return board[1][0] == 'X' ? 1 : 2;
        }
        if(board[2][0] == board[2][2] && board[2][2] == board[2][4] && board[2][0] != ' '){
            return board[2][0] == 'X' ? 1 : 2;
        }
        //CHECK COLUMNS
        if(board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] != ' '){
            return board[0][0] == 'X' ? 1 : 2;
        }
        if(board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] != ' '){
            return board[0][2] == 'X' ? 1 : 2;
        }
        if(board[0][4] == board[1][4] && board[1][4] == board[2][4] && board[0][4] != ' '){
            return board[0][4] == 'X' ? 1 : 2;
        }
        //CHECK DIAGONALS
        if(board[0][0] == board[1][2] && board[1][2] == board[2][4] && board[0][0] != ' '){
            return board[0][0] == 'X' ? 1 : 2;
        }
        if(board[2][0] == board[1][2] && board[1][2] == board[0][4] && board[2][0] != ' '){
            return board[2][0] == 'X' ? 1 : 2;
        }
        return 0;
    }


    static void placeMoveAI(char[][] board, char sign){
        System.out.println("Smart move, You Robot!! Now it is my time to dominate you! BEHOLD MY GENIOUS MOVE!");
        int[][] coordinatesWithSpace = new int[9][2];
        int cell = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == ' ') {
                    coordinatesWithSpace[cell][0] = i;
                    coordinatesWithSpace[cell][1] = j;
                    cell++;
                }
            }
        }
        //return random [i][j] from the first "cell" cells of the array
        int[] randomCoordinates = coordinatesWithSpace[new Random().nextInt(cell)];
        board[randomCoordinates[0]][randomCoordinates[1]] = sign;
    }
    static void placeMove(char[][] board, char sign){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinates for your move (between 1 and 3)");
        int i = sc.nextInt();
        int j = sc.nextInt();
        if(! ( (i >= 1 && i <= 3) && (j >= 1 && j <= 3) ) ){
            System.out.println("Invalid coordinates!");
            placeMove(board, sign);
        }
        else {
            if (j == 1) {
                j = 0;
            }
            if (j == 3) {
                j = 4;
            }
            i--;
            if (board[i][j] == ' ') {
                board[i][j] = sign;
            } else {
                System.out.println("This cell is taken! Please choose another one");
                placeMove(board, sign);
            }
        }
    }

    static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static void generateBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(j == 1 || j == 3){
                    board[i][j] = '|';
                }
                else{
                    board[i][j] = ' ';
                }
            }
        }
    }

}
