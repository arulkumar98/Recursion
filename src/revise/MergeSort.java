package revise;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr ={5,4,3};
//        int[] ans = mergeSort(arr);
//        System.out.println(Arrays.toString(ans));
        mergeSortInPlace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));


    }
    public static int[]  mergeSort(int[] arr){
        if (arr.length == 1){
            return arr;
        }
        int mid = arr.length/2;

        int[] partOne = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] partTwo = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return mergeSortNormal(partOne,partTwo);
    }

    private static int[] mergeSortNormal(int[] partOne, int[] partTwo) {
        int indexOne = 0;
        int indexTwo = 0;
        int ansIndex = 0;
        int[] mergedArray = new int[partOne.length+ partTwo.length];

        while (indexOne < partOne.length && indexTwo < partTwo.length){

            if (partOne[indexOne] < partTwo[indexTwo]){
                mergedArray[ansIndex] = partOne[indexOne];
                indexOne++;
            }else {
                mergedArray[ansIndex] = partTwo[indexTwo];
                indexTwo++;
            }
            ansIndex++;
        }
        //if one array is greater than another array
        while (indexOne < partOne.length){
            mergedArray[ansIndex] = partOne[indexOne];
            indexOne++;
            ansIndex++;
        }

        while (indexTwo < partTwo.length){
            mergedArray[ansIndex] = partTwo[indexTwo];
            indexTwo++;
            ansIndex++;
        }

        return mergedArray;
    }




    public static void mergeSortInPlace(int[] arr, int start, int end){
          if (end - start == 1){
              return;
          }
          int mid = start + (end-start) / 2;

          mergeSortInPlace(arr, start, mid);
          mergeSortInPlace(arr, mid, end);

          mergeArray(arr,start,mid,end);
    }

    private static void mergeArray(int[] arr, int start, int mid, int end) {
        int[] mix = new int[end-start];

        int indexOne = start;
        int indexTwo = mid;
        int mixIndex = 0;

        while (indexOne < mid && indexTwo < end){
            if (arr[indexOne] < arr[indexTwo] ){
                mix[mixIndex] = arr[indexOne];
                indexOne++;
            }else {
                mix[mixIndex] = arr[indexTwo];
                indexTwo++;
            }
            mixIndex++;
        }

        while (indexOne < mid){
            mix[mixIndex] = arr[indexOne];
            indexOne++;
        }

        while (indexTwo < end){
            mix[mixIndex] = arr[indexTwo];
            indexTwo++;
        }

        for (int index = 0; index <mix.length ; index++) {
            arr[start+index] = mix[index];
        }

    }


}
