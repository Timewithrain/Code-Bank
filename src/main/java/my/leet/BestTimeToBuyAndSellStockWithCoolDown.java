package my.leet;

/** 309. 买卖股票的最佳时机含冷冻期 */
public class BestTimeToBuyAndSellStockWithCoolDown {

    static int func(int[] prices) {
        int l = prices.length;
        int[] buy = new int[l];
        int[] sell = new int[l];
        buy[0] = -prices[0];
        for (int i = 1; i < l; i++) {
            if (i>1) {  // 当i>1时，可以在前两日卖出的基础上买入股票
                buy[i] = Math.max(sell[i-2] - prices[i], Math.max(buy[i-1], -prices[i]));
            } else {  // 当i<=1时，仅能第一次买入，不能基于卖出后的价格买入
                buy[i] = Math.max(-prices[i-1], -prices[i]);
            }
            sell[i] = Math.max(sell[i-1], buy[i-1]+prices[i]);
        }
        return sell[l-1];
    }

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2}; // {1}; // {6,1,3,2,4,7}; //
        System.out.println(func(prices));
    }
}
