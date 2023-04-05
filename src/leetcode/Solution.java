package leetcode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        String num = "";
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(num));
    }
    public  List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.isEmpty()){
            return list;
        }
        return helper("", digits,new ArrayList<>());
    }

    public List<String> helper(String p, String up, List<String> list){
        if (up.isEmpty()){
            list.add(p);
            return list;
        }
        int digit = up.charAt(0) - '0'-1;
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
           helper(p + ch, up.substring(1),list);
        }
        return list;
    }

}