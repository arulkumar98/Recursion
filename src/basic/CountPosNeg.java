package basic;

public class CountPosNeg {
    public static void main(String[] args) {
        int[] nums =  {-3,-2,-1,0,0,1,2};
        CountPosNeg countPosNeg = new CountPosNeg();
       int ans =  countPosNeg.maximumCount(nums);
        System.out.println(ans);
    }
    public int maximumCount(int[] nums) {
        int pos = 0,neg = 0;
        for (int num : nums) {
            if (num > 0) {
                pos++;
            } else if (num < 0) {
                neg++;
            }
        }
        return Math.max(pos, neg);
    }
}
