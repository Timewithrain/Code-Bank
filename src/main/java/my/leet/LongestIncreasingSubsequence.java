package my.leet;

import my.leet.utils.ArrayUtils;

/** 300. 最长递增子序列 */
public class LongestIncreasingSubsequence {

    /** 动态规划 时间复杂度O(n^2) */
    static int func(int[] nums) {
        int l = nums.length;
        int[] dp = new int[l];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < l; i++) {
            dp[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    /** 动态规划+二分查找 时间复杂度O(nlogn) */
    static int binarySearch(int[] nums, int i, int j, int target) {
        int l = i;
        int r = j;
        int mid = (l + r) / 2;
        int pos = mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                pos = mid;  // 保证pos是最小的满足nums[pos] >= target的下标
                r = mid - 1;
            }
        }
        return pos;
    }

    static int func2(int[] nums) {
        int l = nums.length;
        int[] d = new int[l];
        d[0] = nums[0];
        int len = 1;
        for (int i = 1; i < l; i++) {
            if (nums[i] > d[len-1]) {
                d[len++] = nums[i];
            } else {
                int idx = binarySearch(d, 0, len-1, nums[i]);
                d[idx] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,4}; // {0,1,0,3,2,3}; // {1,3,6,7,9,4,10,5,6}; // {3,5,6,2,5,4,19,5,6,7,12}; // {10,9,2,5,3,7,101,18}; //
        System.out.println(func2(nums));
    }
}
