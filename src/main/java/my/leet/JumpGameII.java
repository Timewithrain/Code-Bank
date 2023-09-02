package my.leet;

/** 45. 跳跃游戏 II */
public class JumpGameII {

    /** 贪心法实现 */
    static int func(int[] nums) {
        int i = 0;
        int ans = 0;
        while (i < nums.length-1) {
            int range = 0;
            int next = 0;
            for (int j = i; j <= i + nums[i]; j++) {
                if (j == nums.length-1) return ans+1;
                if (j + nums[j] > range) {
                    range = j + nums[j];
                    next = j;
                }
            }
            i = next;
            ans += 1;
        }
        return ans;
    }

    /** 动态规划实现: 从后往前找到从当前点跳到最后点所需要的最少次数，dp[0]为结果 */
    static int func2(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = nums.length-2; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j = i+1; j <= i+nums[i] && j < nums.length; j++) {
                if (dp[j] < min) min = dp[j];
            }
            dp[i] = min==Integer.MAX_VALUE ? Integer.MAX_VALUE : min + 1;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4}; // {2,3,1,1,4};
        System.out.println(func2(nums));
    }
}
