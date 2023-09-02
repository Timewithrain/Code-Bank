package my.leet;

/** 53. 最大子数组和 */
public class MaximumSubarray {

    static int func(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < n; i++) {
            if (dp[i-1] + nums[i] > 0) {
                dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            } else {
                dp[i] = nums[i];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4}; // {-2,1,-3,4,-1,2,1,-5,4};  // {1}; // {5,4,-1,7,8}; //
        System.out.println(func(nums));
    }
}
