package arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {6,5,4,1,2,3};
        System.out.println(search(arr,7,0,arr.length-1));
    }
    static int search(int[] arr, int target, int s, int e){
        if (s > e){   // s = 0 e = 5
            return -1;
        }
        int m = s+(e-s)/2;
        if (arr[m] == target){
            return m;
        }

        if (arr[s] <= arr[m]){
            if (target >= arr[s] && target <= arr[m])
                return search(arr, target, s, m-1);
        }else return search(arr, target, m+1, e);

        if (target >= arr[m] && target <= arr[e]){
            return search(arr, target, m+1,e);
        }
        return search(arr, target, s, m-1);
    }
}