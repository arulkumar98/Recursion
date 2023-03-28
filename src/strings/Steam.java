package strings;

public class Steam {
    public static void main(String[] args) {
        String str = "arulkumar";
        String count = "0123456789";
//        skip("", str);
//        System.out.println(skip2(str));
        System.out.println(skipString(str));
    }

    public static void skip(String processed, String unProcessed) {
        if (unProcessed.isEmpty()) {
            System.out.println(processed);
            return;
        }

        char ch = unProcessed.charAt(0);

        if (ch == 'l' || ch == 'k') {
            skip(processed, unProcessed.substring(1));
        } else {
            skip(processed + ch, unProcessed.substring(1));
        }
    }

    public static String skip2(String unProcessed) {
        if (unProcessed.isEmpty()) {
            return "";
        }
        char ch = unProcessed.charAt(0);

        if (ch == 'l' || ch == 'k') {
            return skip2(unProcessed.substring(1));
        } else {
            return ch + skip2(unProcessed.substring(1));
        }

    }

    public static String skipString(String unProcessed){
        if (unProcessed.isEmpty()){
            return "";
        }
        if (unProcessed.startsWith("aru")){
            return unProcessed.substring(4);
        }else {
            return unProcessed.charAt(0) + skipString(unProcessed);
        }
    }

}
