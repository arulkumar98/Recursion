package revise;

public class Suduko {
    public static void main(String[] args) {
        char[][] arr = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        };

        char[][] arr2 = {
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}
        };

        Suduko suduko = new Suduko();
        suduko.start(arr2);

        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println();
        }
    }

    private void start(char[][] arr) {
        // creating a new arr and converting char to int
        int[][] board = new int[arr.length][arr.length];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr.length; col++) {
                if (arr[row][col] == '.') {
                    board[row][col] = 0;
                } else {
                    board[row][col] = Character.getNumericValue(arr[row][col]);
                }
            }
        }
        solver(board);
        // after getting answer
        for (int row = 0; row <board.length ; row++) {
            for (int col = 0; col <board.length ; col++) {
                arr[row][col] = (char) (board[row][col]+'0');
            }
        }
    }

    private boolean solver(int[][] board) {
        int row = -1;
        int col = -1;
        boolean noEmpty = true;
        // to find the empty element int the array
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board.length; c++) {
                if (board[r][c] == 0) {
                    row = r;
                    col = c;
                    noEmpty = false;
                    break; // break in col
                }
            } //break in row
            if (!noEmpty) {
                break;
            }
        }

        if (noEmpty) {
            return true;
        }
        //backtracking
        for (int num = 1; num <= 9; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solver(board)) {
                    return true;
                } else {
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public boolean isSafe(int[][] arr, int row, int col, int number) {
        // check arr the row, col has the particular number
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[row][i] == number || arr[i][col] == number ){
                    return false;
                }
            }
        }
//
        //3x3 matrix
        int sqrt = (int) Math.sqrt(arr.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart+sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (arr[i][j] == number) {
                    return false;
                }
            }
        }
        return true;
    }

}

