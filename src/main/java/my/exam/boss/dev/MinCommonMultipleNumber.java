package my.exam.boss.dev;

import java.util.Scanner;

/** 1. 求最小公倍数 */
public class MinCommonMultipleNumber {

    static long func(long a, long b) {
        long ans = 0;
        while (b!=0) {
            long tmp = b;
            b = a % b;
            a = tmp;
            ans = Math.abs(a);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong();
        long b = in.nextLong();
        if (a==0 || b==0) {
            System.out.println(0);
        } else {
            long tmp = func(a, b);
            System.out.println(Math.abs(a*b) / tmp);
        }
    }
}
