package revise;

import java.util.Arrays;

import static revise.Swap.swap;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j-1] > arr[j]){
                    swap(arr,j,j-1); // we are swap index not value
                }else {
                    break;
                }
            }
        }
    }



}
