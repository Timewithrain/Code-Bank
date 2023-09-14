package my.leet;

/** 714. 买卖股票的最佳时机含手续费 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    static int func(int[] prices, int fee) {
        int l = prices.length;
        int[] have = new int[l];  // 第i天持有股票的获利
        int[] none = new int[l];  // 第i天不持有股票的获利
        have[0] = -prices[0];
        none[0] = 0;
        for (int i = 1; i < l; i++) {
            have[i] = Math.max(have[i-1], none[i-1] - prices[i]);  // 第一部分：继续持有；第二部分：昨天卖掉以后今天新买入
            none[i] = Math.max(none[i-1], have[i] + prices[i] - fee);  // 第一部分：不买入；第二部分：卖出持有股票
        }
        return none[l-1];
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9}; // {1,3,7,5,10,3}; // {1,3,2,8,4,9};
        int fee = 2; // 3; // 2;
        System.out.println(func(prices, fee));
    }
}
