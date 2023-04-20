package revise;


import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2};
        sort(arr,0,arr.length-1);

    }

    private static void sort(int[] arr, int count, int lastIndex) {
        if (count == arr.length){
            System.out.println(Arrays.toString(arr));
            return;
        }

        int maxValue = 0;
        int indexOfMaxValue = 0;
        for (int i = 0; i < arr.length- count  ; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
                indexOfMaxValue = i;
            }
        }
        //swap
        int temp = arr[lastIndex];
        arr[lastIndex] = maxValue;
        arr[indexOfMaxValue]= temp;
        sort(arr,count+1,lastIndex-1);
    }
}
