import java.util.Arrays;

class HouseRobber2 {
    public static void main(String[] args) {
        int[] house = new int[]{4,2,8,7,6,3};
        int res = rob(house);
        System.out.println(res);
    }

    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int robFirst = helper(Arrays.copyOfRange(nums, 0, nums.length-1));
        int robLast = helper(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(nums[0] + robFirst, robLast);
    }

    public static int helper(int[] nums) {
        int rob1 = 0, rob2 = 0;

        for (int n : nums) {
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}

