package my.leet;

/** 122. 买卖股票的最佳时机II */
public class BestTimeToBuyAndSellStockII {

    static int func(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int profit = prices[i] - prices[i-1];
            if (profit > 0) {
                dp[i] = dp[i-1] + profit;
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4}; // {1,2,3,4,5};  // {7,6,4,3,1}; //
        System.out.println(func(prices));
    }
}
