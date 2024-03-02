import java.util.Scanner;
import java.util.Random;

public class TicTacToe {

    public static void main(String[] args) {
        char[][] board = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };

        printBoard(board);

        char currentPlayer = 'X';
        boolean gameOver = false;

        while (!gameOver) {
            if (currentPlayer == 'X') {
                playerMove(board, currentPlayer);
            } else {
                computerMove(board);
            }

            printBoard(board);
            gameOver = checkGameOver(board, currentPlayer);

            if (!gameOver) {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (char[] row : board) {
            System.out.print("| ");
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    private static void playerMove(char[][] board, char player) {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Player " + player + ", enter your move (row and column, separated by space): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
        } while (!isValidMove(board, row, col));

        board[row][col] = player;
    }

    private static void computerMove(char[][] board) {
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (!isValidMove(board, row, col));

        System.out.println("Computer chooses: " + (row + 1) + ", " + (col + 1));
        board[row][col] = 'O';
    }

    private static boolean isValidMove(char[][] board, int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }
        return true;
    }

    private static boolean checkGameOver(char[][] board, char player) {
        if (checkWin(board, player)) {
            System.out.println("Player " + player + " wins!");
            return true;
        }

        if (isBoardFull(board)) {
            System.out.println("It's a draw!");
            return true;
        }

        return false;
    }

    private static boolean checkWin(char[][] board, char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }

        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
                (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    private static boolean isBoardFull(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
