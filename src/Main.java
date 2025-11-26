import java.util.Scanner;

public class Main {
    public static final int rows = 3;
    public static final int columns = 3;
    public static final String[][] board = new String[rows][columns];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String player1 = "X";
        String player2 = "O";
        int p1row = -1;
        int p1col = -1;
        int p2row = -1;
        int p2col = -1;
        boolean player1Valid = false;
        boolean player2Valid = false;
        boolean gameOver = false;
        boolean round = false;
        boolean playAgain;


        while (!gameOver) {
            resetBoard();
            while (!round) {
                player1Valid = false;
                player2Valid = false;

                while (!player1Valid) {
                    p1row = InputHelper.getRangedInt(scan, "Select the row for your move (Player 1)", 1, 3);
                    p1col = InputHelper.getRangedInt(scan, "Select the column for your move (Player 1)", 1, 3);

                    if (isValidMove(p1row - 1, p1col - 1)) {
                        player1Valid = true;
                    } else {
                        System.out.println("Error - Invalid move.");
                    }
                }

                board[p1row - 1][p1col - 1] = player1;
                displayBoard();
                if (isWin(player1) || isTie()) {
                    break;
                }

                while (!player2Valid) {
                    p2row = InputHelper.getRangedInt(scan, "Select the row for your move (Player 2)", 1, 3);
                    p2col = InputHelper.getRangedInt(scan, "Select the column for your move (Player 2)", 1, 3);

                    if (isValidMove(p2row - 1, p2col - 1)) {
                        player2Valid = true;
                    } else {
                        System.out.println("Invalid move");
                    }
                }

                board[p2row - 1][p2col - 1] = player2;
                displayBoard();
                if (isWin(player2) || isTie()) {
                    break;
                }
            }

            if (isWin(player1)) {
                System.out.println("Player One Wins!");
                break;
            } else if (isWin(player2)) {
                System.out.println("Player Two Wins!");
                break;
            } else if (isTie()) {
                System.out.println("You Tied!");
                break;
            }

        }

        scan.nextLine();
        gameOver = InputHelper.getYNConfirm(scan, "Play another game? [Y/N]");
    }

    public static void displayBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void resetBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = "-";
            }
        }
    }

    private static boolean isValidMove(int row, int column) {
        boolean valid = false;
        if (board[row][column] == "-") {
            valid = true;
        }
        return valid;
    }

    private static boolean isWin(String player) {
        boolean win = false;
        if (isColWin(player) || isRowWin(player) || isDiagWin(player)) {
            win = true;
        }
        return win;
    }

    private static boolean isColWin(String player) {
        boolean colWin = false;
        int loops = 0;
        for (int j = 0; j < board[0].length; j++) {
            loops = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[j][i].equals(player)) {
                    loops++;
                }
                if (loops == 3) {
                    colWin = true;
                    break;
                }
            }
        }
        return colWin;
    }

    private static boolean isRowWin(String player) {
        boolean rowWin = false;
        int loops = 0;
        for (int j = 0; j < board[0].length; j++) {
            loops = 0;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j].equals(player)) {
                    loops++;
                }
                if (loops == 3) {
                    rowWin = true;
                    break;
                }
            }
        }
        return rowWin;
    }

    private static boolean isDiagWin(String player) {
        boolean diagWin = false;

        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            diagWin = true;
        } else if (board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player)) {
            diagWin = true;
        }

        return diagWin;
    }

    private static boolean isTie() {
        boolean tie = false;
        int loops = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].equals("-")) {
                    loops++;
                    break;
                }
            }
        }
        if (loops == 0) {
            tie = true;
        }
        return tie;
    }
}