package BackTracking;

public class NKnights {
    public static void main(String[] args) {
    int num = 4;
    boolean[][] arr = new boolean[num][num];
    knight(arr,0,0,num);
    }

    public static void knight(boolean[][] board, int row, int col, int knight) {
        if (knight == 0) {
            display(board);
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            knight(board, row + 1, 0, knight);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }
        knight(board, row, col + 1, knight);

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValid(board, row-2, col-1)) {
            if (board[row-2][col-1]) {    // to check the particular index has knight
                return false;
            }
        }

        if (isValid(board, row-2, col+1)) {
            if (board[row-2][col+1]) {
                return false;
            }
        }

        if (isValid(board, row-2, col+1)) {
            if (board[row -2][col+1]) {
                return false;
            }
        }

        if (isValid(board, row-1, col+2)) {
            if (board[row-1][col+2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(boolean[][] arr, int row, int col) {
        return row >= 0 && row < arr.length && col >= 0 && col < arr.length;

//        if (row >= 0 && row < arr.length && col >= 0 && col < arr.length ){
//            return true;
//        }else return false;
    }

    private static void display(boolean[][] board) {
        for (boolean[] arr : board) {
            for (boolean element : arr) {
                if (element) {
                    System.out.print("K ");
                } else System.out.print("* ");
            }
            System.out.println();
        }
    }
}
