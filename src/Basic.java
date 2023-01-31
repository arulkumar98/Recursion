public class Basic {
    public static void main(String[] args) {
//         rec(1);
         int[] arr = {0,1,2,3,4,5};
        System.out.println(arr.length-1);
    }
    public static void rec(int a){
        if (a == 10  ){
            return;
        }
        System.out.println(a);
        rec(a+1);

    }

}
