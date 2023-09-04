package my.exam.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 小美的元素删除
 * 给定一个数组array，和一个整数k，小美希望从array中删除k个数字，使得剩余数字两两互为倍数。
 * 请问小美有多少种删除方法，结果较大，输出对1000000007取模后的结果。
 * 通过0%
 */
public class MeiElementDelete {

    static int MOD = 1000000007;

    /** 求组合数C^m_n */
    static long combination(int m, int n) {
        long up = 1;
        for (int i = 1; i <= n; i++) {
            up *= i;
        }
        long down = 1;
        for (int i = 1; i <= (n-m); i++) {
            down *= i;
        }
        long A = up/down;
        down = 1;
        for (int i = 1; i <= m; i++) {
            down *= i;
        }
        long C = A/down;
        return C;
    }

    static int func(int[] array, int k) {
        int l = array.length;
        int ans = 0;
        Arrays.sort(array);
        for (int i = 0; i < l; i++) {
            int count = 0;
            for (int j = i+1; j < l; j++) {
                if (array[j] % array[i] == 0) count++;
            }
            if (count >= l-k-1) {
                int n = (int) combination(l-k-1, count);
                ans = (ans+n)%MOD;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        System.out.println(func(array, k));

    }
}


//6 4
//1 4 2 3 6 7