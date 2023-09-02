package my.leet.redbook;

import java.util.HashMap;

/**
 * 给定一个数组nums和一个数k，nums中包含多少个由k统治的子区间
 * k统治一个区间的含义：k为该区间内的众数，区间内k的个数大于等于k
 */
public class DominateArray {

    static int func(int[] nums, int k) {
        int[][] dp = new int[nums.length+1][nums.length+1];
        int ans = 0;
        int cntK = 0;
        for (int i = 0; i < k; i++) {
            if (nums[i]==k) cntK++;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= nums.length; j++) {

            }
        }
        return 0;
    }

    /** 暴力解法 */
    static int func2(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length-k+1; i++) {
            for (int j = i+k-1; j < nums.length; j++) {
                if (k == getDominate(nums, i, j)) {
                    ans += 1;
                }
            }
        }
        return ans;
    }

    static int getDominate(int[] nums, int start, int end) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = nums[start];
        for (int i = start; i <= end; i++) {
            int cnt = 0;
            if (map.containsKey(nums[i])) {
                cnt = map.get(nums[i]) + 1;
                map.put(nums[i], cnt);
            } else {
                map.put(nums[i], cnt = 1);
            }
            if (map.get(maxNum) < cnt) {
                maxNum = nums[i];
            }
        }
        return maxNum;
    }


    public static void main(String[] args) {

    }
}
