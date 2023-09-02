package my.exam.netease;

/**
 * 宝藏分配
 * 给定一个宝藏的价值列表nums，和一个整数k，要求将全部宝藏分配给两个地图，使得两个地图的宝藏价值都不低于k，问有多少种分配方案
 * 通过100%
 */
public class TreasureCaseDistribute {

    static int dfs(int[] nums, int[] mask, int i, int occupy, int k, int sum, int n) {
        int ans = 0;
        if (i == nums.length-1) {  // 递归至最后一个元素，判断是否满足条件
            int part = 0;
            for (int j = 0; j < nums.length; j++) {
                if (mask[j] == 1) {
                    part += nums[j];
                }
            }
            if (part >= k && sum-part >= k) ans = n+1;  // 若满足条件，若是则分配方案+1
        } else {
            mask[i] = occupy;  // 使用mask记录分配方案，为1表示分配给第一个地图，剩余的自动分配给另一个地图
            ans += dfs(nums, mask, i+1, 1, k, sum, n);
            ans += dfs(nums, mask, i+1, 0, k, sum, n);
            mask[i] = 0;
        }
        return ans;
    }

    public static int countPartitions (int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < 2*k) return 0;
        int[] mask = new int[nums.length];
        ans += dfs(nums, mask, 0, 0, k, sum, 0);  // 第一位分配给第二个地图的所有情况
        ans += dfs(nums, mask, 0, 1, k, sum, 0);  // 第一位分配给第一个地图的所有情况
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 3;
        int ans = countPartitions(nums, k);
        System.out.println(ans);
    }
}
