public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinarySearch binarySearch = new BinarySearch();
        int ans = binarySearch.recursion(arr, 6, 0, arr.length - 1);
        System.out.println(ans);
    }

    public int recursion(int[] arr, int target , int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (target == arr[mid]) {
            return mid;
        }
        if (target > arr[mid]) {
            return recursion(arr, target, mid + 1, end);
        }
            return recursion(arr, target, start, mid - 1);
    }
}
