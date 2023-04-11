package leetcode;

import java.util.ArrayList;
import java.util.List;

public class NQueens51 {
    public static void main(String[] args) {
        NQueens51 nQueens51 = new NQueens51();
        System.out.println(nQueens51.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return queens(board, 0,new ArrayList<>());

    }



    public static List<List<String>> queens(boolean[][] board, int row,List<List<String>> ans) {
        if (row == board.length) {
            List<String> rowList = new ArrayList<>();
            for (boolean[] arr : board) {
                List<String> subList = new ArrayList<>();
                for (boolean element : arr) {
                    if (element) {
                        subList.add("Q");
                    } else {
                        subList.add(".");
                    }
                }
                String rowString = String.join("", subList);
                rowList.add(rowString);
            }
            ans.add(rowList);
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

    private static boolean ifSafe(boolean[][] board, int row, int col) {
        // vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        //   for left diagonal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        // for right diagonal
        int maxRight = Math.min(row, col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
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

    }










