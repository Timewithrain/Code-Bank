package my.leet;

/** 1646. 获取生成数组中的最大值 */
public class GetMaximumInGeneratedArray {

    static int func(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] dp = new int[n+1];
        dp[1] = 1;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            if (i%2 == 0) {
                dp[i] = dp[i/2];
            } else {
                dp[i] = dp[i/2] + dp[i/2+1];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 7; // 3; // 2; //
        System.out.println(func(n));
    }
}
