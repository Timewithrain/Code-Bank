package my.exam.boss.dev;

import java.util.Scanner;

/** 3. 买卖股票的最佳时机III */
public class BestTimeToSellStockIII {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        int low = a[0];
        for (int i = 1; i < n; i++) {
            low = Math.min(low, a[i]);
            dp1[i] = Math.max(dp1[i-1], a[i] - low);
        }
        int high = a[n-1];
        for (int i = n-2; i >= 0; i--) {
            high = Math.max(high, a[i]);
            dp2[i] = Math.max(dp2[i+1], high - a[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp1[i] + dp2[i]);
        }
        System.out.println(ans);
    }
}
