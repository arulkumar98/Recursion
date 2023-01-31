package esay;

public class ReverseNumber {
    private static void bruteforce(int n) {
        int ans = 0;
        while (n != 0){
           int temp = n % 10;
            n /=10;
            ans =   ans * 10 +temp;
        }
        System.out.print(ans);
    }
    static int ans = 0;
    private static void recOne(int n) {
      if(n == 0){
          return;
      }
      int rem = n % 10;
      ans = ans * 10 + rem;
      recOne(n/10);

    }
    static  int rec2(int n){
        int digit = (int)(Math.log10(n)) + 1;
        return helper(n, digit);
    }

    private static int helper(int n, int digit) {
        if ( n % 10 == 0){
            return n;
        }
        int rem = n % 10;
        return rem * (int)(Math.pow(10,digit-1)) + helper(n/10,digit - 1);
    }

    public static void main(String[] args) {
        int n = 1234;
        System.out.println(rec2(n));
        System.out.println((int)Math.pow(10,4));
    }
}
