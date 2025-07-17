import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        System.out.println("Welcome to Tic Tac Toe!");
        printBoard();

        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + ", enter your move (row [1-3] and column [1-3]):");
            int row, col;

            while (true) {
                System.out.print("Row: ");
                row = scanner.nextInt() - 1;

                System.out.print("Column: ");
                col = scanner.nextInt() - 1;

                if (row >= 0 && row < 3 && col >= 0 && col < 3) {
                    if (board[row][col] == ' ') {
                        board[row][col] = currentPlayer;
                        break;
                    } else {
                        System.out.println("That cell is already occupied! Try again.");
                    }
                } else {
                    System.out.println("Invalid position! Try again.");
                }
            }

            printBoard();

            // Check for win
            if (checkWin()) {
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            }
            // Check for draw
            else if (isBoardFull()) {
                System.out.println("The game is a draw!");
                gameEnded = true;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    // Print the game board
    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Check if the board is full (draw)
    static boolean isBoardFull() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == ' ')
                    return false;
        return true;
    }

    // Check if current player won
    static boolean checkWin() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == currentPlayer &&
                 board[i][1] == currentPlayer &&
                 board[i][2] == currentPlayer) ||
                (board[0][i] == currentPlayer &&
                 board[1][i] == currentPlayer &&
                 board[2][i] == currentPlayer)) {
                return true;
            }
        }

        // Check diagonals
        if ((board[0][0] == currentPlayer &&
             board[1][1] == currentPlayer &&
             board[2][2] == currentPlayer) ||
            (board[0][2] == currentPlayer &&
             board[1][1] == currentPlayer &&
             board[2][0] == currentPlayer)) {
            return true;
        }

        return false;
    }
}
