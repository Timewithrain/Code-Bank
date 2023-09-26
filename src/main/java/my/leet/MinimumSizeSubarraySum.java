package my.leet;

/** 209. 长度最小的子数组 */
public class MinimumSizeSubarraySum {

    /** 暴力法 */
    static int func(int target, int[] nums) {
        int l = nums.length;
        int ans = Integer.MAX_VALUE;
        int[] sum = new int[l];
        sum[0] = nums[0];
        if (sum[0]>=target) ans = 1;
        for (int i = 1; i < l; i++) {
            sum[i] = sum[i-1] + nums[i];
            if (sum[i]>=target) ans = Math.min(ans, i+1);
            for (int j = 1; target <= sum[i] && j <= i; j++) {
                if (sum[i] - sum[i-j] >= target) {
                    ans = Math.min(ans, j);
                    break;
                }
            }
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5}; // {2,3,1,2,4,3}; // {1,1,1,1,1}; // {2,3,1,2,4,3}; //
        int target = 15; // 7; // 11; //
        System.out.println(func(target, nums));
    }
}
