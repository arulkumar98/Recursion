package basic;

public class CountNeg {
    public static void main(String[] args) {
        
    }
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (grid[i][j] <0){
                    count++;
                }
            }
        }return count;
    }
}
