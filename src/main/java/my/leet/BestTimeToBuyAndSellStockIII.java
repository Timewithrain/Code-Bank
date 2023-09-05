package my.leet;

/** 123. 买股票的最佳时机III */
public class BestTimeToBuyAndSellStockIII {

    /** 动态规划 */
    static int func(int[] prices) {
        int l = prices.length;
        int[] dp1 = new int[l];
        int[] dp2 = new int[l];
        int ans = 0;
        int cur_max = prices[0];
        int cur_min = prices[0];
        for (int i = 1; i < l; i++) {  // 从前向后，统计第一段
            if (prices[i] < cur_min) {
                cur_min = prices[i];
                cur_max = prices[i];
            } else {
                cur_max= Math.max(cur_max, prices[i]);
            }
            dp1[i] = Math.max(dp1[i-1], cur_max - cur_min);
        }
        cur_max = prices[l-1];
        cur_min = prices[l-1];
        for (int i = l-2; i >= 0; i--) {  // 从后向前，统计第二段
            if (prices[i] > cur_max) {
                cur_min = prices[i];
                cur_max = prices[i];
            } else {
                cur_min= Math.min(cur_min, prices[i]);
            }
            dp2[i] = cur_max - cur_min;
            ans = Math.max(ans, dp1[i]+dp2[i]);  // 计算两段之和
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0}; //{7,6,4,3,1}; // {3,3,5,0,0,3,1,4}; // {1,2,3,4,5};  //
        System.out.println(func(prices));
    }
}
