package strings.permutation;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
//        System.out.println(str.length());
//        permutation("",str);
        permutationListInternal5("",str);
    }
    public static void permutation(String pro, String unPro){
        if (unPro.isEmpty()){
            System.out.println(pro);
            return;
        }
        char ch = unPro.charAt(0);
        for (int i = 0; i <= pro.length(); i++) {
            String one = pro.substring(0,i);
//            System.out.println(one);
            String two = pro.substring(i, pro.length());
//            System.out.println(two);
//            System.out.println("ch "+ch);
            permutation(one + ch + two,unPro.substring(1));
        }
    }

    public static ArrayList<String> permutationList(String pro, String unPro,ArrayList<String> list){
        if (unPro.isEmpty()){
            list.add(pro);
            return list;
        }
        char ch = unPro.charAt(0);
        for (int i = 0; i <= pro.length(); i++) {
            String one = pro.substring(0,i);
            System.out.println(one);
            String two = pro.substring(i, pro.length());
            System.out.println(two);
            System.out.println("ch "+ch);
            permutation(one + ch + two,unPro.substring(1));
        }
        return list;
    }

    public static ArrayList<String> permutationListInternal5(String pro, String unPro){
        if (unPro.isEmpty()){
           ArrayList<String> list = new ArrayList<>();
           list.add(pro);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = unPro.charAt(0);
        for (int i = 0; i <= pro.length(); i++) {
            String one = pro.substring(0,i);
            String two = pro.substring(i, pro.length());
            ans.addAll(permutationListInternal5(one + ch + two,unPro.substring(1)));
        }
        return ans;
    }
}
