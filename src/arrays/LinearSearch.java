package arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {22,77,21,81,80,79};
        System.out.println(linear(arr,8,0));
        System.out.println(linearBoolean(arr,8,0));

    }
    private static boolean linearBoolean(int[] arr, int target, int index) {
        if(index == arr.length){
            return false;
        }
        return arr[index] == target || linearBoolean(arr,target,index+1);
    }

    public static int linear(int[] arr , int target, int index){
        //base condition
        if (index == arr.length-1){
            return -1;
        }
        if (arr[index] == target){
            return index;
        }else
            return linear(arr,target,index+1);
    }
}
