package my.exam.tencent;

import java.util.Scanner;

/**
 * 牛牛不怕勇敢向前
 * 牛牛的初始战斗力x为0，初始勇气为0
 * 给定一个长度为n的数组，代表n个怪兽的战斗力，牛牛可以以任意顺序选择怪兽进行战斗
 * 若牛牛战斗力x小于n[i]，牛牛触发被动技能“牛牛不怕勇敢向前”，战斗力x增加至n[i]，勇气增加n[i]-x
 * 若牛牛战斗力x大于或等于n[i]，牛牛打败怪兽，并且战斗力降低至n[i]
 * 请问牛牛打败所有怪兽后累计最多可以获得多少勇气？
 * 输入：
 * 3
 * 1 2 3
 * 输出：
 * 3
 */
public class NiuNiuNotAfraid {

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static int dfs(int[] a, int i, int ans) {
        if (i==a.length-1) {
            int cur = a[0];
            for (int j = 1; j <= i; j++) {
                if (a[j]>a[j-1]) {
                    cur += a[j] - a[j-1];

                }
            }
            return Math.max(ans, cur);
        }
        for (int j = i; j < a.length; j++) {
            swap(a, i, j);
            ans = dfs(a, i+1, ans);
            swap(a, i, j);
        }
        return ans;
    }

    static int func(int[] a) {
        return dfs(a, 0, 0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int j = 0; j < n; j++) {
            nums[j] = in.nextInt();
        }
        System.out.println(func(nums));
    }
}
