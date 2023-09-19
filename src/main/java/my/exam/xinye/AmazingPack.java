package my.exam.xinye;

import java.util.Scanner;

/**
 * 神奇的背包
 * 背包总的承重为M，现在有n个物品需要放入背包中，这些物品的重量分别为weight[i]，要从中选择一些物品使其重量恰好为M，请问有多少种不同的选择
 */
public class AmazingPack {

    /** 动态规划 空间优化 */
    static int func(int[] weight, int M) {
        int[] dp = new int[M+1];
        dp[0] = 1;
        for (int i = 0; i < weight.length; i++) {
            for (int j = M; j >= weight[i]; j--) {
                dp[j] += dp[j - weight[i]];
            }
        }
        return dp[M];
    }

    /** 动态规划 */
    static int func2(int[] weight, int M) {
        int l = weight.length;
        int[][] dp = new int[l][M+1];
        for (int i = 0; i <= M; i++) {  // 初始化数据
            if (i >= weight[0]) {
                dp[0][i] = 1;
            }
        }
        for (int i = 1; i < l; i++) {
            for (int j = 1; j <= M; j++) {
                if (j >= weight[i]) {  // 判断能否装入第i个物品
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - weight[i]];  // 当前的方案数量=不装第i个物品的数量+装第i个物品的数量
                } else {
                    dp[i][j] = dp[i][j-1];  // 若不能装入，则保持不变
                }
            }
        }
        return dp[l-1][M];
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int M = in.nextInt();
        int n = in.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = in.nextInt();
        }
        int ans = func(weight, M);
        System.out.println(ans);
        System.out.println(func2(weight, M));
    }
}

/*
40
3
20
20
20
*/
