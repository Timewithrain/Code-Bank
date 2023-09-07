package my.exam.ctrip;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小游的元素变化
 * 给定一个数组nums和一个范围[l, r]，定义一种操作，对nums中任意元素+1，同时对nums中任意元素-1
 * 请问最少多少次操作后使得nums中的元素都处于[l, r]范围中？
 * 输入一个t代表询问次数，一个n代表数组长度，一个l代表范围下界，一个r代表范围上界
 * 输入n个数代表nums数组
 * 输出t行代表t个回答
 * 通过80%
 */
public class YouElementChange {

    static int func(int[] nums, int l, int r) {
        int len = nums.length;
        Arrays.sort(nums);
        long down = 0;
        long up = 0;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] < l) down += l-nums[i];
            if (nums[i] > r) up += nums[i]-r;
            sum += nums[i];
        }
        if (sum < len*l || sum > len*r) return -1;
        return (int) Math.max(down, up);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] n = new int[t];
        int[] l = new int[t];
        int[] r = new int[t];
        int[] ans = new int[t];
        for (int i = 0; i < t; i++) {
            n[i] = in.nextInt();
            l[i] = in.nextInt();
            r[i] = in.nextInt();
            int[] nums = new int[n[i]];
            for (int j = 0; j < n[i]; j++) {
                nums[j] = in.nextInt();
            }
            ans[i] = func(nums, l[i], r[i]);
        }
        for (int i = 0; i < t; i++) {
            System.out.println(ans[i]);
        }
    }
}
