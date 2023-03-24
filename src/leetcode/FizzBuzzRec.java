package leetcode;

class FizzBuzzRec {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        return checkDuplicates(nums, 0, nums.length - 1);
    }
    
    private static boolean checkDuplicates(int[] nums, int start, int end) {
        if (start >= end) {
            return false;
        }
        
        int mid = start + (end - start) / 2;
        boolean leftHasDuplicates = checkDuplicates(nums, start, mid);
        boolean rightHasDuplicates = checkDuplicates(nums, mid + 1, end);
        
        if (leftHasDuplicates || rightHasDuplicates) {
            return true;
        }
        
        for (int i = start; i <= mid; i++) {
            for (int j = mid + 1; j <= end; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
