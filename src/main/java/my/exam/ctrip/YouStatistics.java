package my.exam.ctrip;

import java.util.Scanner;

/**
 * 小游的排列统计
 * 给定一个元素互不相同且长度为n的排列(数值1-n)，计算有多少个排列方式满足以下要求
 * 排列中相邻元素之和不为质数
 * 通过100%
 */
public class YouStatistics {

    static boolean isPrime(int n) {
        boolean ans = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    static int dfs(int[] nums, int i, int ans) {
        if (i == nums.length-1) {
            for (int j = 1; j < nums.length; j++) {
                if (isPrime(nums[j]+nums[j-1])) {
                    return ans;
                }
            }
            return ans + 1;
        }
        for (int j = i; j < nums.length; j++) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            ans = dfs(nums, i+1, ans);
            t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        return ans;
    }

    static int func(int n) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        int ans = dfs(nums, 0, 0);
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(func(n));
    }
}
