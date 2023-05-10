import java.util.Arrays;
import java.util.Scanner;

public class Connect4 {
    // constants for the board dimensions
    public static final int ROWS = 6;
    public static final int COLS = 7;

    // 2D array to represent the game board
    public static int[][] board = new int[ROWS][COLS];

    // function to print the board
    public static void printBoard() {
        for (int[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    // function to check if a column is full
    public static boolean isColumnFull(int col) {
        return board[ROWS-1][col] != 0;
    }

    // function to drop a disc into a column
    public static void dropDisc(int col, int player) {
        for (int row = 0; row < ROWS; row++) {
            if (board[row][col] == 0) {
                board[row][col] = player;
                break;
            }
        }
    }

    // function to check if a player has won
    public static boolean hasPlayerWon(int player) {
        // check horizontal
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS-3; col++) {
                if (board[row][col] == player && board[row][col+1] == player && board[row][col+2] == player && board[row][col+3] == player) {
                    return true;
                }
            }
        }

        // check vertical
        for (int row = 0; row < ROWS-3; row++) {
            for (int col = 0; col < COLS; col++) {
                if (board[row][col] == player && board[row+1][col] == player && board[row+2][col] == player && board[row+3][col] == player) {
                    return true;
                }
            }
        }

        // check diagonal (down-right)
        for (int row = 0; row < ROWS-3; row++) {
            for (int col = 0; col < COLS-3; col++) {
                if (board[row][col] == player && board[row+1][col+1] == player && board[row+2][col+2] == player && board[row+3][col+3] == player) {
                    return true;
                }
            }
        }

        // check diagonal (down-left)
        for (int row = 0; row < ROWS-3; row++) {
            for (int col = 3; col < COLS; col++) {
                if (board[row][col] == player && board[row+1][col-1] == player && board[row+2][col-2] == player && board[row+3][col-3] == player) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // initialize the board with zeros
        for (int[] row : board) {
            Arrays.fill(row, 0);
        }

        // main game loop
        int player = 1;
        boolean gameOver = false;
        while (!gameOver) {
            // print the board
            printBoard();

            // get player input
            System.out.print("Player " + player + "'s turn. Choose a column (1-" + COLS + "): ");
            int col = scanner.nextInt() - 1;
            // check if the column is valid
            if (col < 0 || col >= COLS) {
                System.out.println("Invalid column number!");
                continue;
            }

            // check if the column is full
            if (isColumnFull(col)) {
                System.out.println("Column is full!");
                continue;
            }

            // drop the disc
            dropDisc(col, player);

            // check if the player has won
            if (hasPlayerWon(player)) {
                printBoard();
                System.out.println("Player " + player + " has won!");
                gameOver = true;
            }

            // check for a tie game
            boolean isTie = true;
            for (int[] row : board) {
                for (int cell : row) {
                    if (cell == 0) {
                        isTie = false;
                        break;
                    }
                }
                if (!isTie) {
                    break;
                }
            }
            if (isTie) {
                printBoard();
                System.out.println("Game is a tie!");
                gameOver = true;
            }

            // switch to the other player
            player = (player == 1) ? 2 : 1;
        }
    }
}