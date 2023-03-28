package strings;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        String str = "abc";
        subseq("",str);
//        System.out.println(sublist("",str,new ArrayList<>()));

    }
    public static void subseq(String processed, String unProcessed){
        if (unProcessed.isEmpty()){
            System.out.print(processed+ " ");
            return;
        }
        char ch = unProcessed.charAt(0);
        subseq(processed +ch ,unProcessed.substring(1));
        subseq(processed,unProcessed.substring(1));
    }

    public static ArrayList<String> sublist (String processed, String unProcessed,ArrayList<String>list){
        if (unProcessed.isEmpty()) {
            list.add(processed);
        }
        char ch = unProcessed.charAt(0);
        subseq(processed +ch ,unProcessed.substring(1));
        subseq(processed,unProcessed.substring(1));
        return list;
    }
}
