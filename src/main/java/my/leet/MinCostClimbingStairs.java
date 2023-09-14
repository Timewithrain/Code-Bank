package my.leet;

/** 746. 最小花费爬楼梯 */
public class MinCostClimbingStairs {

    static int func(int[] cost) {
        int l = cost.length;
        int[] dp = new int[l];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < l; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-2]) + cost[i];
        }
        return Math.min(dp[l-2], dp[l-1]);
    }

    static int func2(int[] cost) {
        int l = cost.length;
        int[] dp = new int[l+1];
        for (int i = 2; i <= l; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]) ;
        }
        return dp[l];
    }

    public static void main(String[] args) {
        int[] cost = {1,100,1,1,1,100,1,1,100,1}; // {10, 15, 20}; // {10,15,20}; //
        System.out.println(func(cost));
        System.out.println(func2(cost));
    }
}
