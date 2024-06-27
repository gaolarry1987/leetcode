public class ArraySortedOrNot {
    public static void main(String[] args) {
        int[] arr1 = new int[]{2,1,3,5,4};
        int[] arr2 = new int[]{1,2,3,4,5};

        System.out.println(sorted(arr1,0));
        System.out.println(sorted(arr2,0));
    }

    static boolean sorted(int[] arr, int index){
        if(index == arr.length-1){
            return true;
        }
        return arr[index]<arr[index+1] && sorted(arr, index+1);
    }
}
