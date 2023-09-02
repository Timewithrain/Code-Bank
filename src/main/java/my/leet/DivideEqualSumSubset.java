package my.leet;

public class DivideEqualSumSubset {

    static boolean dp(int[] nums) {
        if (nums.length<2) return false;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2 != 0) return false;
        // 初始化dp数组
        int[][] dp = new int[nums.length+1][sum/2 + 1];
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = 1;
        if (nums[0] <= sum/2)
            dp[1][nums[0]] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum/2; j++) {
                if (j >= nums[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j-nums[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][sum/2]==1;
    }

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        boolean ans = dp(nums);
        System.out.println(ans);
    }

}
