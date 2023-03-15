package arrays;

public class IsSortedArray {
    public boolean bruteforce(int[] arr){
        for (int i = 1; i <arr.length ; i++) {
            if (arr[i-1] > arr[i]){
                return false;
            }
        }
        return true;
    }

    public boolean rec(int[] arr, int index){
       //base condition
        if (index == arr.length-1) {
            return true;
        }
        return arr[index] < arr[index +1] && rec(arr,index+1);
    }

    public static void main(String[] args) {
        int[] arr= {1,8,3,7,5};
        IsSortedArray isSortedArray = new IsSortedArray( );
        boolean ans = isSortedArray.bruteforce(arr);
        System.out.println(isSortedArray.rec(arr,0));
    }

}
