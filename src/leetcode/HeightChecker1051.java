package leetcode;

import java.util.Arrays;

public class HeightChecker1051 {
    public static void main(String[] args) {
        HeightChecker1051 heightChecker1051 = new HeightChecker1051();
        int[] arr = {1, 1, 4, 2, 1, 3};
//        int ans = heightChecker1051.heightChecker(arr);
//        System.out.println(ans);
       int ans =  heightChecker1051.start(arr);
        System.out.println(ans);
    }

    public int heightChecker(int[] heights) {
        int[] expected = Arrays.copyOf(heights, heights.length);
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

    public int start(int[] arr){
        int[] arr2 = Arrays.copyOf(arr,arr.length);
        recurssion(arr2,arr.length,0);
      return find(arr,arr2,0,0);

    }

    public void recurssion(int[] arr, int row, int index) {
        int stop = (arr.length - 1) - row;
        if (index == stop) {
            recurssion(arr, row + 1, 0);
        }
        if (index == arr.length - 1) {
            return;
        }

        if (arr[index] > arr[index + 1]) {
            int temp = arr[index];
            arr[index] = arr[index + 1];
            arr[index + 1] = temp;
        }

        recurssion(arr, row, index + 1);
    }

    public int find(int[] arr, int[] arr2,int num, int count){
        if (num == arr.length){
            return count;
        }
        if (arr[num] != arr2[num]){
            count +=1 ;

        }
        return find(arr,arr2,num+1,count);
    }


}
