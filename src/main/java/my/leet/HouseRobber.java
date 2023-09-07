package my.leet;

/** 198. 打家劫舍 */
public class HouseRobber {

    static int func(int[] nums) {
        int l = nums.length;
        if (l==1) return nums[0];
        if (l==2) return Math.max(nums[0], nums[1]);
        if (l==3) return Math.max(nums[0]+nums[2], nums[1]);
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < l; i++) {
            dp[i] += Math.max(dp[i-2], dp[i-3]) + nums[i];
        }
        return Math.max(dp[l-2], dp[l-1]);
    }

    /** 标准解法 */
    static int func2(int[] nums) {
        int l = nums.length;
        if (l==1) return nums[0];
        if (l==2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[l];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < l; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        return dp[l-1];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1}; // {2,7,9,3,1}; //
        System.out.println(func2(nums));
    }
}
