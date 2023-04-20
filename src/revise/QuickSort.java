package revise;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9,10,8,7};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        System.out.println("end");


    }
    public static void quickSort(int[] arr, int low, int high){
        if (low >= high){
            return;
        }

        int start = low;
        int end = high;
        int mid = start+(end-start) /2;
        int pivot = arr[mid];

        while (start <= end){

            while (arr[start] < pivot){
                start++;
            }

            while (arr[end] > pivot){
                end--;
            }

            if (start <= end){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
//        if(check(arr)){
//            return;
//        }

        quickSort(arr,low,end);
        quickSort(arr,start,high);
    }

    private static boolean check(int[] arr) {
        for (int i = 0; i <arr.length-1 ; i++) {
            if (arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
