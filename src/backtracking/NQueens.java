package backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] box = new boolean[4][4];
        System.out.println(queens(box, 0,new ArrayList<>()));

    }

    public static List<List<String>> queens(boolean[][] board, int row,List<List<String>> ans) {
        if (row == board.length) {
            List<String> subList = new ArrayList<>();
            for (boolean[] arr : board) {
                StringBuilder str = new StringBuilder();

                for (boolean element : arr) {
                    if (element) {
                        str.append("Q");
                    } else str.append(".");
                    subList.add(str.toString());
                }
            }
            ans.add(subList);
            return ans;
        }



        //ok

        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {
                board[row][col] = true;
                queens(board, row + 1,ans);
                board[row][col] = false;
            }
        }
        return ans;
    }



    private static boolean isSafe(boolean[][] board, int row, int col) {
        // check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // diagonal left
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if(board[row-i][col-i]) {
                return false;
            }
        }

        // diagonal right
        int maxRight = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if(board[row-i][col+i]) {
                return false;
            }
        }

        return true;
    }

    public static void display(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean element : row) {
                if (element) {
                    System.out.print("Q ");
                } else System.out.print("X ");
            }
            System.out.println();
        }
    }
}
