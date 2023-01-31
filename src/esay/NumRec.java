package esay;

public class NumRec {
    public static void main(String[] args) {
       fun(5);
    }
    public static void fun(int a){
        if (a == 0){
            return;
        }
        System.out.print(a+" ");
        fun(a-1);
        System.out.println(a+" ");
    }
}
