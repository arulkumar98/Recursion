package basic;

public class Zoho {
    public static void main(String[] args) {
        int a = 400000;
        int one = 0;
        int two = 0;
        int five = 0;
        while (a > 0){
            one +=2;
            a-=2;
            two += 3;
            a -=3;
            five +=4;
            a -=4;
        }
        System.out.println(two);
    }
}
