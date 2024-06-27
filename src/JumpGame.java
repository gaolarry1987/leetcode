public class JumpGame {
    public static void main(String[] args) {
        int[] game = new int[]{4,3,7,4,1,5,9};
        boolean res = jump(game);
        System.out.println(res);
    }

    private static boolean jump(int[] nums){
        int target = nums.length-1;
        for(int i = nums.length-1; i >= 0; i--){
            if(i + nums[i] >= target) target = i;
        }
        return target == 0;
    }
}
