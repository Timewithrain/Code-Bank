package my.leet;

/** 62. 不同路径 */
public class UniquePaths {

    static int func(int m, int n) {
        if (m==1 && n==1) return 1;
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        for (int i = 0; i < m || i < n; i++) {
            if (i<m) dp[i][0] = 1;
            if (i<n) dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int m = 3; // 3; // 7; //
        int n = 3; // 2; // 3; //
        System.out.println(func(m, n));

    }
}
