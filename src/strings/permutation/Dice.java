package strings.permutation;

import java.util.ArrayList;

public class Dice {
    public static void main(String[] args) {
        System.out.println(dice("",4,new ArrayList<>()));

    }

    private static ArrayList<String> dice(String pro, int target,ArrayList<String> ans) {
        if (target == 0){
            ans.add(pro);
            return ans;
        }
        for (int i = 1; i <= 6 && i <= target ; i++) {
            dice(pro + i, target -i,ans);
        }
        return ans;
    }

    private static ArrayList<String> diceinternal(String pro, int target) {
        if (target == 0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add(pro);
            return ans;
        }
        ArrayList<String> ans  = new ArrayList<>();
        for (int i = 1; i <= 6 && i <= target ; i++) {
           ans.addAll(diceinternal(pro + i, target -i));
        }
        return ans;
    }
}
