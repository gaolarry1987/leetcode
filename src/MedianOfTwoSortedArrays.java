import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,5,7,8};
        int[] arr2 = new int[]{2,4,6,9};
        int[] res = mergedTwo(arr1,arr2);
        System.out.println(Arrays.toString(res));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[]res = mergedTwo(nums1, nums2);
        int n = res.length;
        if(n%2==0){
            return (res[(n-1)/2]+res[n/2])/2.0;
        }else{
            return res[n/2];
        }
    }
    public static int[] mergedTwo(int[]A,int[]B){
        int[] mergedArray = new int[A.length+B.length];
        int i = 0, j = 0, k = 0;
        while(i < A.length && j < B.length){
            mergedArray[k++] = (A[i] <=B[j]) ? A[i++] : B[j++];
        }
        while(i < A.length){
            mergedArray[k++] = A[i++];
        }
        while(j < B.length){
            mergedArray[k++] = B[j++];
        }
        return mergedArray;
    }
}
