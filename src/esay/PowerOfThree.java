package esay;

class PowerOfThree {
    public static void main(String[] args) {
        PowerOfTwo powerOfThree = new PowerOfTwo();
        System.out.println(powerOfThree.isPowerOfTwo(9));
    }
    public boolean isPowerOfFour(int n) {
        if (n <=0){
            return false;
        }
        if (n == 1){
            return true;
        }
        if (n % 3 !=0){
            return false;
        }
        return isPowerOfFour(n/3);
    }
}