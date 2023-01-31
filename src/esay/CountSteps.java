package esay;

public class CountSteps {
    public static void main(String[] args) {
        CountSteps countSteps = new CountSteps();
        System.out.println(countSteps.numberOfSteps(14));
    }

    public int numberOfSteps(int num) {
        return help(num, 0);
    }

    public int help(int num, int count) {
        if (num == 0) {
            return count;
        }
        if (num % 2 == 0) {
            return help(num / 2, count + 1);
        } else
            return help(num - 1, count + 1);
    }


}
