package revise;

import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        int n = arr.length;
//        bubbleSortRec(arr,arr.length);
//        recurssion(arr, 0, 0);
//        bubbleSortRecursive(arr,n);
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int[] arr) {
        boolean swapped = false;
        for (int i = 0; i < arr.length; i++) {
            swapped = false;
            for (int j = 0; j < arr.length -1 -i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped){
                break;
            }
        }
    }

    public static void recurssion(int[] arr, int row, int index) {
        int stop = (arr.length - 1) - row;
        if (index == stop) {
            recurssion(arr, row + 1, 0);
        }
        if (index == arr.length - 1) {
            return;
        }

        if (arr[index] > arr[index + 1]) {
            int temp = arr[index];
            arr[index] = arr[index + 1];
            arr[index + 1] = temp;
        }

        recurssion(arr, row, index + 1);
    }

}
