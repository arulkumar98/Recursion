package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class ArrayDifference {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3};
        int[] arr2 = {2,4,6};
        ArrayDifference arrayDifference = new ArrayDifference();
        System.out.println(arrayDifference.findDifference(arr1,arr2));
    }
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> setOne = new HashSet<>();
        Set<Integer> setTwo = new HashSet<>();
        for (int j : nums1) {
            setOne.add(j);
        }
        for (int j : nums2) {
            setTwo.add(j);
        }
        List<List<Integer>> list= new ArrayList<>();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        for(int num : setOne){
            if(!setTwo.contains(num)){
                list.get(0).add(num); }
        }
        for(int num : setTwo){
            if(!setOne.contains(num)){
                list.get(1).add(num);
            }
        }
        return list;

    }
}