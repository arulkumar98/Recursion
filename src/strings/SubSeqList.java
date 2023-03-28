package strings;

import java.util.ArrayList;

public class  SubSeqList {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(subseqlist("",str));
    }

    private static ArrayList<String> subseqlist(String  pro, String unPro) {
        if (unPro.isEmpty()){
            ArrayList<String>list = new ArrayList<>();
            list.add(pro);
            return list;
        }
        char ch = unPro.charAt(0);
        ArrayList<String> left = subseqlist(pro + ch, unPro.substring(1));
        ArrayList<String> right = subseqlist(pro , unPro.substring(1));

        left.addAll(right);
        return left;

    }
}
