package strings;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
//       List<List<Integer>> ans = sunSet(arr);
//       for(List<Integer> list : ans){
//           System.out.println(list);
//       }
        System.out.println(sunSet(arr));
    }

    public static List<List<Integer>> sunSet(int[] arr){
        List<List<Integer>> outerList= new ArrayList<>();
        outerList.add(new ArrayList<>());
        for (int num:arr) {
            int n = outerList.size();

            for (int i = 0; i < n ; i++) {    // i = index of outerList , n = outerList size
                List<Integer> internalList = new ArrayList<>(outerList.get(i));
                System.out.println(num);
                internalList.add(num);
                System.out.println("Inter " + internalList );
                outerList.add(internalList);
                System.out.println("Outer" + outerList);

            }
        }
        return outerList;
    }
}
