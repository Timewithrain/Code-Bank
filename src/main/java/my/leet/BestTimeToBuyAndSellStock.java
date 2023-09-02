package my.leet;

/** 121. 买卖股票的最佳时机 */
public class BestTimeToBuyAndSellStock {

    static int func(int[] prices) {
        int low = 0;
        int high = 0;
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[low]) {
                low = i;
                high = i;
            } else if (prices[i] > prices[high]) {
                high = i;
            }
            ans = Math.max(ans, prices[high] - prices[low]);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4}; // {7,6,4,3,1}; //
        System.out.println(func(prices));
    }
}
