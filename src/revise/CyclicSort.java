package revise;

import java.util.Arrays;
import static revise.Swap.swap;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
//        cyclic(arr);
        cyclicWhile(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void cyclic(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] != i+1){
                swap(arr,arr[i]-1,i);
            }
        }
    }

    public static void cyclicWhile(int[] arr){
        int i = 0;
        while (i < arr.length){
            int correctIndex = arr[i] -1;
            if (arr[i] != arr[correctIndex]){
                swap(arr,i,correctIndex);
            }
        }
    }
}
