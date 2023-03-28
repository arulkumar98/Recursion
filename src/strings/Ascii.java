package strings;

public class Ascii {
    public static void main(String[] args) {
        String abc = "abc";
        subSeqAscii("", abc);
    }

    private static void subSeqAscii(String p, String up) {
        if (up.isEmpty()){
            System.out.print(p+ " ");
            return;
        }
        char ch = up.charAt(0);
        subSeqAscii(p+ ch, up.substring(1));
        subSeqAscii(p,up.substring(1));
        subSeqAscii(p+(ch+0),up.substring(1));
    }
}
