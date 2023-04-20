package backtracking;

public class Sudoku {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        if (solve(board)) {
            display(board);
        } else {
            System.out.println("Cannot solve");
        }

    }

    private static void display(int[][] board) {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    private static boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;  //why -1 just for initialise
        int col = -1;

        boolean emptyLeft = true;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 0) {
                    row = r;
                    col = c;
                    emptyLeft = false;        // if true == no empty, false == has empty
                    break;
                }
            }
            //break for row
            if (emptyLeft == false) {
                break;
            }
        }

        if (emptyLeft == true) {
            return true;
            // problem solved
        }
        // backtrack
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true; // found the answer
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;

    }


    private static boolean isSafe(int[][] board, int row, int col, int num) {
        //for row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {    // every element in row  i is col by col
                return false;
            }
        }
        //for colum
        for (int[] arr : board) {
            if (arr[col] == num) {   // arr =
                return false;
            }
        }

        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int r = rowStart; r < rowStart + sqrt; r++) {
            for (int c = colStart; c < colStart + sqrt; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
