package my.leet;

import java.util.Arrays;

/** 322. 零钱兑换 */
public class CoinChange {

    /** 动态规划 */
    static int func(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE/2;
            for (int coin : coins) {
                for (int n = 1; n * coin <= i; n++) {
                    dp[i] = Math.min(dp[i], dp[i - n*coin] + n);
                }
            }
        }
        return dp[amount] != Integer.MAX_VALUE/2 ? dp[amount] : -1;
    }

    /** 动态规划优化 */
    static int func2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] != amount+1 ? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5}; // {1}; // {2}; //
        int amount = 11; // 0; // 3; //
        int ans = func2(coins, amount);
        System.out.println(ans);
    }
}
