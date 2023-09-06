package my.leet;

/** 188. 买卖股票的最佳时机IV */
public class BestTimeToBuyAndSellStockIV {

    static int func(int[] prices, int k) {
        int l = prices.length;
        int[][] buy = new int[l][k];
        int[][] sell = new int[l][k];
        int ans = 0;
        for (int i = 0; i < l; i++) {
            buy[i][0] = -prices[i];
        }
        for (int i = 1; i < k; i++) {
            buy[0][i] = Integer.MIN_VALUE / 2;  // 可能出现最小值求差的情况，除以2避免溢出
            sell[0][i] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i <l ; i++) {
            buy[i][0] = Math.max(buy[i][0], buy[i-1][0]);
            sell[i][0] = Math.max(sell[i-1][0], buy[i-1][0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[i][j] = Math.max(buy[i-1][j], sell[i-1][j-1] - prices[i]);  // 每列j仅能买卖一次，因此sell[i-1]取[j-1]，取上一次卖出的结果买入
                sell[i][j] = Math.max(sell[i-1][j], buy[i-1][j] + prices[i]);  // 本次卖出的收益必由本次买入得到，因此buy[i-1]取[j]
            }
        }
        for (int i = 0; i < k; i++) {
            ans = Math.max(ans, sell[l-1][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0}; //{2,4,1}; // {3,2,6,5,0,3};
        int k = 4;
        System.out.println(func(prices, k));
    }
}
