package my.exam.meituan;

import java.util.Scanner;

/**
 * 4.小美的数组构造
 * 给定一个数组a，小妹希望构造一个数组b，满足以下条件：
 * a与b的每个位置对应的值都不同
 * a与b和相同
 * b中的数都是正整数
 * 1 < n < 300
 * 1 < a[i] < 500
 * 通过%0
 */
public class MeiArrayConstruct {

    static long all(int n) {
        long ans = 1;
        for (int i = 2; i < n; i++) {
            ans *= n;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a  = new int[n];
        int[] map = new int[300];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            map[a[i]]++;
        }
        long ans = all(n);
        long minus = 0;
        for (int i = 0; i < 300; i++) {
            if (map[i] > 1) {
                minus += map[i] * all(n-map[i]);
            }
        }
        ans = ans-minus;
        System.out.println(ans%1000000007);
    }
}
