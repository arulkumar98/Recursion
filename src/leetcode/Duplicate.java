package leetcode;

import java.util.Arrays;

public class Duplicate {
    //leetcode  217
    public static void main(String[] args) {
        int[] arr = {5,4,7,8,7};
//        System.out.println(containsDuplicate(arr));
        System.out.println(containsDuplicate2(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1 ; i++) {
            if (nums[i] == nums[i+1]){
                return true;
            }
        }
        return false;

    }
    public static boolean containsDuplicate2(int[] nums) {
        return bubble(nums, 0, 1);
    }

//    private static boolean rec(int[] nums, int i, int j) {
//        if (i == nums.length-1){
//            return false;
//        }
//        if (j == nums.length) {
//            return rec(nums,i+1,i+1+1);
//        }
//        if (nums[i] == nums[j]){
//            return true;
//        }
//        return rec(nums, i, j+1);
//    }


   public static boolean bubble(int[] arr, int r, int c) {
        if (r == arr.length-1) {
            return false;
        }
        if (c < arr.length) {
            if (arr[r] == arr[c]) {
                return true;
            }
           return bubble(arr, r, c+1);

        } else {
           return bubble(arr, r+1, r+1+1);
        }

    }
}
