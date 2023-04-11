package leetcode;


public class Sudoku {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        char[][] arr = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        sudoku.solveSudoku(arr);

    }

    public void solveSudoku(char[][] board) {
        char[][] ans = new char[board.length][board.length];
        ans = start(board);
        for (int r = 0; r < board.length ; r++) {
            for (int c = 0; c < board.length; c++) {
                board[r][c] =  ans[r][c];
            }
        }

    }

    public char[][] start(char[][] board){
        int[][] boardNum = new int[board.length][board.length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == '.') {
                    boardNum[row][col] = 0;
                } else {
                    boardNum[row][col] = Character.getNumericValue(board[row][col]);
                }
            }
        }
        solve(boardNum);

        // convert char array
        char[][] arr = new char[boardNum.length][boardNum.length];
        for (int r = 0; r <arr.length ; r++) {
            for (int c = 0; c < arr.length ; c++) {
                arr[r][c] = (char) (boardNum[r][c] + '0');
            }
        }
        return arr;
    }

    public boolean solve(int[][] board) {
        int n = board.length;
        int row = -1;
        int col = -1;

        boolean noEmpty = true;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == 0) {
                    row = r;
                    col = c;               //  false = found some empty element true = no empty found
                    noEmpty = false;
                    break;
                }
            }
            if (noEmpty == false) {
                break;
            }
        }
        if (noEmpty == true) {
            return true;
        }
        // backtrack number
        for (int number = 1; number <= 9; number++) {
            if (isSafe(board, row, col, number)) {
                board[row][col] = number;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;

    }

    // check the element is safe for placing in the array;
    public boolean isSafe(int[][] board, int row, int col, int num) {
        // for row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // for col
        for (int[] arr : board) {
            if (arr[col] == num) {
                return false;
            }
        }

        // for 3x3 matrix
        int sqrt = (int) (Math.sqrt(board.length));
        int rowStart = row - row % sqrt;
        int rowEnd = rowStart + sqrt;
        int colStart = col - col % sqrt;
        int colEnd = colStart + sqrt;

        for (int r = rowStart; r < rowEnd; r++) {
            for (int c = colStart; c < colEnd; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true;

    }

    public void display(char[][] board) {
        for (char[] row : board) {
            for (char num : row) {
                System.out.print(num);
            }
            System.out.println();
            // new line
        }
    }

}
