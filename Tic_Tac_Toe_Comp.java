import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe_Comp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        char[][] board = new char[3][3];

        for(int i = 0;i<board.length;i++){
            for (int j =0;j<board.length;j++){
                board[i][j] = ' ';
            }
            System.out.println();
        }

        boolean gameOver = false;
        char player = 'X';
        boolean boardful = false;

        while (!gameOver){
            System.out.println("Grid Show!");
            print(board);
            System.out.println("Player "+player+" your move: ");
            int row = sc.nextInt();
            int col = sc.nextInt();

            if (board[row][col]==' ') {
                board[row][col] = player;
                gameOver = isWin(board, player);

                boardful = checkFul(board);
                if (boardful && !gameOver) {
                    System.out.println("Grid Show!");
                    print(board);
                    System.out.println("Game Draw!!");
                    return;
                }
                if (gameOver) {
                    System.out.println("Player " + player + " won!");
                }
                player = (player == 'X') ? 'O' : 'X';
            }else{
                System.out.println("Invalid Move!!");
            }

        }

    }




    public static boolean isWin(char[][] board,char player){
        //Row win condition
        for (int row = 0;row<board.length;row++){
            if (board[row][0]==player&&board[row][1]==player&&board[row][2]==player){
                return true;
            }
        }

        //Col win condition
        for (int i =0;i<board.length;i++){
            if (board[0][i]==player&&board[1][i]==player&&board[2][i]==player){
                return true;
            }
        }

        //Digonal win condition
        if (board[0][0]==player&& board[1][1]==player&& board[2][2]==player){
            return true;
        }
        if (board[2][0]==player&&board[1][1]==player&&board[0][2]==player){
            return true;
        }
        return false;
    }

    public static void print(char[][] board){
        for (int i = 0;i<board.length;i++){
            for (int j =0;j<board.length;j++){
                System.out.print(board[i][j]+" |");
            }
            System.out.println();
        }
    }

    public static boolean checkFul(char[][]board){
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board.length;j++){
                if (board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }


}
