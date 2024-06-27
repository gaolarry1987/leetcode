public class HouseRobber {
    public static void main(String[] args) {
        int[] house = new int[] {2,3,2,4,2};
        int res = rob(house);
        System.out.println(res);
    }
    private static int rob(int[] nums){
        int rob1 = 0, rob2 = 0;
        if(nums.length == 0) return 0;
        //[rob1, rob2, num, ... ]
        for(int num : nums){
            int temp = rob2;
            rob2 = Math.max(rob1 + num, rob2);
            rob1 = temp;
        }
        return rob2;
    }
}
