public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,80,89,92,103};
        int target = 80;
        System.out.println(search(array, target,0,array.length-1));
    }
    static int search (int[] arr, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end-start)/2;
        if(target == arr[mid]){
            return mid;
        }
        if(target < arr[mid]){
            return search(arr, target, start, mid-1);
        }else{
            return search(arr, target, mid+1, end);
        }
    }
}
