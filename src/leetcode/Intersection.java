package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Intersection {
    public static void main(String[] args) {
        Intersection intersection = new Intersection();
        int[] arr1 = {4, 9, 5};
        int[] arr2 = {5, 5};
//        intersection.intersection(arr1,arr2);
        int[] ans = intersection.intersection(arr1, arr2);
        System.out.println(Arrays.toString(ans));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
//        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int k : nums1) {
            for (int i : nums2) {
                if (k == i) {
                    if (nums1.length < nums2.length) {
                        set.add(k);
                    } else set.add(i);
                }
            }
        }

        // this is not efficient
//        Integer[] arr = set.toArray(new Integer[0]);
//        int[] intArr = Arrays.stream(arr).mapToInt(Integer::intValue).toArray();
//        return intArr;


        int[] ans = new int[set.size()];
        int j = 0;
        for (Integer i : set) {
            ans[j++] = i;
        }
        int[] array = new int[ans.length];
        System.arraycopy(ans, 0, array, 0, ans.length);
        return array;
    }
}