package my.exam.netease2;

import my.leet.utils.ArrayUtils;

import java.util.Scanner;

public class HongSequenceArray {

    static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j]= t;
    }

    // 长度为n的数组，每次可以交换i和(i+2)%n的位置的数，能否通过有限次的交换使数组变为单调不减的数组
    static boolean dfs(int[] nums, int i, int n) {
        if (i == n) {
            return true;
        }
        if (i+2 < n && nums[i] > nums[(i + 2) % n]) {
            swap(nums, i, (i + 2) % n);
        }
        return dfs(nums, i + 1, n);
    }

    static boolean func(int[] nums) {
        boolean ans = true;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 2) % n]) {
                swap(nums, i, (i + 2) % n);
            }
        }
        ArrayUtils.printArray(nums);
        for (int i = 0; i < n-2; i++) {
            if (nums[i] > nums[(i + 2) % n]) {
                swap(nums, i, (i + 2) % n);
            }
        }
        ArrayUtils.printArray(nums);
        for (int i = 0; i < n-1; i++) {
            if (nums[i] > nums[i+1]) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        boolean[] ans = new boolean[t];
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = in.nextInt();
            }
            ans[i] = func(nums);
        }
        for (int i = 0; i < t; i++) {
            System.out.println(ans[i] ? "YES" : "NO");
        }
//        int[] nums = {4, 3, 2, 1};
//        System.out.println(func(nums));
    }
}
