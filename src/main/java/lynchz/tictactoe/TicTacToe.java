package lynchz.tictactoe;

import java.util.Scanner;

import java.util.Scanner;

public class TicTacToe {
    private static char[][] board = new char[3][3];
    private static char currentPlayer = 'X';

    public static void main(String[] args) {
        initializeBoard();
        playGame();
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    private static void playGame() {
        boolean gameWon = false;
        boolean gameDraw = false;
        int moves = 0;

        while (!gameWon && !gameDraw) {
            displayBoard();

            if (moves == 9) {
                System.out.println("It's a draw!");
                gameDraw = true;
                break;
            }

            System.out.println("Player " + currentPlayer + ", enter row (0-2) and column (0-2): ");
            int row, col;
            Scanner scanner = new Scanner(System.in);

            row = scanner.nextInt();
            col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                gameWon = checkForWin(row, col);
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                moves++;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        displayBoard();
    }

    private static boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-';
    }

    private static boolean checkForWin(int row, int col) {
        return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer) ||
               (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer) ||
               (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
               (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    private static void displayBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
