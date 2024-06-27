import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> ans = subSet(arr);
        for(List<Integer> list: ans){
            System.out.println(list);
        }

        int[] arr2 = new int[]{1,2,2};
        System.out.println(subsetsWithDup(arr2));
    }

    static List<List<Integer>> subSet(int[] nums){
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());

        for(int num: nums){
            int n = res.size();
            for(int i = 0; i < n; i++){
                List<Integer> internal = new ArrayList<>(res.get(i));
                internal.add(num);
                res.add(internal);
            }
        }

        return res;
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());
        int start = 0, end = 0;

        for(int i = 0; i < nums.length; i++){
            start = 0;
            int n = res.size();
            if(i > 0 && nums[i] == nums[i-1]){
                start = end +1;
            }
            end = res.size()-1;
            for(int j = start; j < n; j++){
                List<Integer> internal = new ArrayList<>(res.get(j));
                internal.add(nums[i]);
                res.add(internal);
            }
        }
        return res;
    }
}
