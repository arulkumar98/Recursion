package esay;

public class SumoDigit {
    public static void main(String[] args) {
        int ans = sumOfDigit(134);
        System.out.println(ans);
    }

    private static int sumOfDigit(int n) {
        if (n == 0){
            return 0;
        }
        return (n % 10) + sumOfDigit(n / 10);
    }
    private static int productOfDigit(int n) {
        if (n % 10 == n){
            return n;
        }
        return (n % 10) * sumOfDigit(n / 10);
    }
}
