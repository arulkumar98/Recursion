package revise;

import static backtracking.NQueens.display;

public class Knights {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        horse(board, 0, 0, 4);

    }

    public static void horse(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        // check row or col index of outbound reach last index
        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            horse(board, row + 1, 0, knights);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            horse(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        horse(board, row, col+1, knights);

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }

        if (isValid(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }

        if (isValid(board, row - 1, col + 2)) {
            return !board[row - 1][col + 2];
        }

        return true;
    }

    public static boolean isValid(boolean[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board.length;
    }

}
