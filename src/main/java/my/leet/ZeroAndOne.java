package my.leet;

/**
 * 474. 一和零
 */
public class ZeroAndOne {

    /** 三维类01背包问题，动态规划 */
    static int dp(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for (int k = 1; k <= strs.length; k++) {
            String str = strs[n];
            int zero = 0;
            int one = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i>=zero && j>=one) {
                        dp[k][i][j] = Math.max(dp[k-1][i-zero][j-one]+1, dp[k-1][i][j]);
                    } else {
                        dp[k][j][j] = dp[k-1][i][j];
                    }
                }
            }
        }
        return dp[strs.length-1][m][n];
    }

    public static void main(String[] args) {
        String[] strs = {"10","0001","111001","1","0"};
        int m = 4;
        int n = 3;
        int ans = dp(strs, m, n);
        System.out.println(ans);
    }

}
