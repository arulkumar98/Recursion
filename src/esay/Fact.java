package esay;

public class Fact {
    public static void main(String[] args) {
       int ans = fact(10);
        System.out.println(ans);
    }

    private static int fact(int n) {
        if (n == 1){
            return 1;
        }
        return n * fact(n-1);
    }
    private static int sum(int n) {
        if (n == 1){
            return 1;
        }
        return n + fact(n-1);
    }
}
