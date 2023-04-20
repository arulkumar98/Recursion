package revise;


import java.util.ArrayList;
import java.util.List;

public class Queen {
    public static void main(String[] args) {
        int n = 4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queenPath(board, 0,new ArrayList<>()));
    }

    public static List<List<String>> queenPath(boolean[][] board, int row, List<List<String>> list) {
//        if (row == board.length){
//            display(board);
//            System.out.println("_____________________");
//            return;
//        }
        if (row == board.length) {
            list.add(addlist(board));
            return list;
        }


        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                queenPath(board, row + 1, list);
                board[row][col] = false;  // backtracking
            }
        }

        return list;
    }

    private static List<String> addlist(boolean[][] board) {
        List<String> mainList = new ArrayList<>();

        for (boolean[] arr : board) {
            List<String> subList = new ArrayList<>();
            for (boolean element : arr) {
                if (element) {
                    subList.add("Q");
                } else {
                    subList.add(".");
                }
            }

            String addString = String.join("",subList);
            mainList.add(addString);
        }
        return mainList;

    }


    private static boolean isSafe(boolean[][] board, int row, int col) {
        //same row and col
        for (int index = 0; index < row; index++) {
            if (board[index][col]) {
                return false;
            }
        }
        // for left
        int leftMax = Math.min(row, col);
        for (int i = 1; i <= leftMax; i++) {
            if (board[row - 1][col - 1]) {
                return false;
            }
        }
        // for right
        int rightMax = Math.min(row, (board.length - 1) - col); // may queen at con near of right
        for (int i = 1; i <= rightMax; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    public static void display(boolean[][] board) {
        for(boolean[] row : board) {
            for(boolean element : row) {
                if (element) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

}
