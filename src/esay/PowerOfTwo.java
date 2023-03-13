package esay;
class PowerOfTwo {
    public static void main(String[] args) {
        PowerOfTwo powerOfTwo = new PowerOfTwo();
        boolean ans = powerOfTwo.isPowerOfTwo(6);
        System.out.println(ans);
    }
    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n/2);
    }
}