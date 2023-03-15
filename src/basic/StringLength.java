package basic;

public class StringLength {
    public static void main(String[] args) {
        String str = "Arul";
//        int ans = rec2(str);
//        System.out.println(ans);
        System.out.println(str.substring(2).length());
    }

    private static int rec(String str) {
       if (str.equals("")){
           return 0;
       }else
           return rec(str.substring(1)) + 1;
    }

}
