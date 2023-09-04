package my.exam.meituan2;

import java.util.Scanner;

/**
 * 小美的数组
 * 给定数组array，小妹每次对数组中的元素作以下操作：
 * 1. 对于任意的i，array[i] = array[i] * 2
 * 2. 对于任意的i，array[i] = array[i] / 2
 * 请问最少经过多少次操作，可以使得数组中的所有元素小于等于第一个元素，求最少的操作次数。
 * 通过100%
 */
public class MeiArray {

    static int mul(int a, int b) {
        int cnt = 0;
        while (a<b) {
            a *= 2;
            cnt++;
        }
        return cnt;
    }

    static int div(int a, int b) {
        int cnt = 0;
        while (a<b) {
            b /= 2;
            cnt++;
        }
        return cnt;
    }

    static int func(int[] array) {
        int l = array.length;
        if (l==1) return 0;
        int ans = Integer.MAX_VALUE;
        int max = array[0];
        for (int i = 1; i < l; i++) {
            max = Math.max(max, array[i]);
        }
        if (max <= array[0]) return 0;
        int dis = mul(array[0], max);
        for (int i = 0; i <= dis; i++) {
            int tmp = 0;
            int target = array[0] << i;
            for (int j = 0; j < l; j++) {
                if (array[j] > target) {
                    tmp += div(target, array[j]);
                }
            }
            ans = Math.min(ans, tmp+i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        System.out.println(func(array));
    }
}
