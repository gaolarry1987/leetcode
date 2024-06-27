public class RotateBinarySearch {
    public static void main(String[] args) {
        int[] arr1 = new int[]{8,9,0,1,2,3,4,5,6,7};
        System.out.println(search(arr1,3, 0,arr1.length-1));

    }

    static int search(int[] arr, int target, int s, int e){
        if(s > e) return -1;

        int mid = (s+e)/2;

        if(arr[mid] == target){
            return mid;
        }

        if (arr[s] <= arr[mid]) {
            if(target >= arr[s] && target <= arr[mid]){
                return search(arr, target, s, mid-1);
            }else{
                return search(arr, target, mid+1,e);
            }
        }

        //End in second half, the weired one
        if(target >= arr[mid] && target <= arr[e]){
            return search(arr, target, mid+1,e);
        }
        return search(arr, target, s, mid-1);
    }
}
