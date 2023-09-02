package my.exam.meituan;

import java.util.Scanner;

/**
 * 2.小美的求和
 * 给定一个长度为n的数组a，小美希望求出a数组的和，小美有一个魔法能将数组中任意两个数的+号替换成*号，小美希望你帮她求出可能的最大的和。
 * 通过100%
 */
public class MeiSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n  = in.nextInt();
        int[] a = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            sum += a[i];
        }
        long ans = Long.MIN_VALUE;
        long add = 0;
        long mul = 0;
        for (int i = 1; i < n; i++) {
            add = a[i] + a[i-1];
            mul = (long) a[i] * a[i-1];
            ans = Math.max(ans, sum-add+mul);
        }
        System.out.println(ans);
    }
}
