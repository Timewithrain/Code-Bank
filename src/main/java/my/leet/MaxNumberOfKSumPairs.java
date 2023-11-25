package my.leet;

import java.util.Arrays;

/** 1679. K和数对的最大数目 */
public class MaxNumberOfKSumPairs {

    static int func(int[] nums, int k) {
        int ans = 0;
        int l = nums.length;
        Arrays.sort(nums);
        int i = 0, j = l-1;  // 双指针法
        while (i < j) {
            if (nums[i] + nums[j] < k) {
                i++;
            } else if (nums[i] + nums[j] > k) {
                j--;
            } else {
                ans++;
                i++;
                j--;
            }
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
