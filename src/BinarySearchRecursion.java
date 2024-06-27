import java.util.ArrayList;
import java.util.List;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 12, 24, 34, 56, 68, 80};
        int[] arr2 = new int[]{2, 3, 14, 25, 34, 56, 69, 89};
        int[] arr3 = new int[]{3, 4, 14, 14, 23, 44, 55, 66};

        System.out.println(binarySearch(arr1, 56, 0, arr1.length - 1));
        System.out.println(binarySearch(arr2, 25, 0, arr2.length - 1));
        findAllIndex(arr3, 14, 0);
        System.out.println(list);
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;  // Element not found
        }

        int mid = (start + end) / 2;

        if (arr[mid] == target) {
            return mid;  // Element found
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);  // Search in the left half
        } else {
            return binarySearch(arr, target, mid + 1, end);  // Search in the right half
        }
    }

    static List<Integer> list= new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index){
        if(index == arr.length){
            return;
        }

        if(arr[index] == target){
            list.add(index);
        }

        findAllIndex(arr,target,index+1);
    }
}
