package my.leet;

/** 674. 最长连续递增序列 */
public class LongestContinuousIncreasingSubsequence {

    static int func(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < l; i++) {
            if (nums[i] > nums[i-1]) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1}; // {2,2,2,2,2}; // {1,3,5,4,7};
        System.out.println(func(nums));
    }
}
