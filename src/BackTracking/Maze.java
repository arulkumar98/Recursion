package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(maze(3,3));
//        mazePath2("",3,3,2);
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        System.out.println(Math.min(2,8));
//        System.out.println(board[0].length-1);
//        backTracking("", board, 0, 0);
//        int[][] way = new int[board.length][board[0].length];
//        backTrackingCount("",board,0,0,way,1);

    }

    public static void backTrackingCount(String pro, boolean[][] maze, int row, int col, int[][] path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] num : path) {
                System.out.println(Arrays.toString(num));
            }
            System.out.println(pro);
            System.out.println();
        }

        if (!maze[row][col]) {
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;

        if (row < maze.length - 1) {
            backTrackingCount(pro+"Down " , maze, row + 1, col, path, step+1);
        }
        if (col < maze[0].length - 1) {
            backTrackingCount(pro+ "Right ", maze, row, col + 1, path, step+1);
        }
        if (row > 0){
            backTrackingCount(pro+ "Up ", maze, row-1, col,path,step+1);
        }
        if (col > 0){
            backTrackingCount(pro+ "Down ", maze, row, col-1, path, step+1);
        }
        maze[row][col] = true;
        path[row][col] = 0;

    }


    public static void backTracking(String pro, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(pro);
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        maze[row][col] = false;

        if (row < maze.length - 1) {
            backTracking(pro + "Down ", maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            backTracking(pro + "Right ", maze, row, col + 1);
        }
        if (row > 0) {
            backTracking(pro + "Up ", maze, row - 1, col);
        }
        if (col > 0) {
            backTracking(pro + "Left ", maze, row, col - 1);
        }
        maze[row][col] = true;
    }

    public static void mazeNoWay(String p, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(p);
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        if (row < maze.length - 1) {
            mazeNoWay(p + 'D', maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            mazeNoWay(p + 'R', maze, row, col + 1);
        }
    }

    public static int maze(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int left = maze(row - 1, col);
        int right = maze(row, col - 1);
        return left + right;
    }

    public static void mazePath(String path, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(path);
            return;
        }
        if (row > 1) {
            mazePath(path + "Down ", row - 1, col);
        }
        if (col > 1) {
            mazePath(path + "Right ", row, col - 1);
        }
    }

    public static ArrayList<String> mazePathList(String path, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1) {
            list.addAll(mazePathList(path + "Down ", row - 1, col));
        }
        if (col > 1) {
            list.addAll(mazePathList(path + "Right ", row, col - 1));
        }
        return list;
    }

    public static ArrayList<String> mazePathListDiagonal(String path, int row, int col) {
        if (row == 1 && col == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (row > 1 && col > 1) {
            list.addAll(mazePathList(path + "Diagonal ", row - 1, col - 1));
        }
        if (row > 1) {
            list.addAll(mazePathList(path + "Vertical ", row - 1, col));
        }
        if (col > 1) {
            list.addAll(mazePathList(path + "Horizontal ", row, col - 1));
        }

        return list;
    }

    public static void mazePath2(String path, int row, int col, int r) {
        if (row == 1 && col == 1) {
            System.out.println(path);
            return;
        }
        if (row == r && col == r) {
            return;
        }
        if (row > 1) {
            mazePath(path + "Down ", row - 1, col);
        }
        if (col > 1) {
            mazePath(path + "Right ", row, col - 1);
        }
    }


}
