package my.leet;

import my.leet.utils.ArrayUtils;

/** 718. 最长重复子数组 */
public class MaximumLengthOfRepeatSubarray {

    static int func(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[][] dp = new int[l1+1][l2+1];
        int ans = 0;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (nums1[i-1]==nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        ArrayUtils.printArray(dp);
        return ans;
    }


    public static void main(String[] args) {
        int[] nums1 = {0,1,1,1,1}; // {1,2,3,2,1}; // {1,2,3,2,8}; // {0,0,1,1,0}; //
        int[] nums2 = {1,0,1,0,1}; // {3,2,1,4,7}; // {5,6,1,4,7}; // {0,1,1,0,0}; //
        System.out.println(func(nums1, nums2));
    }
}
