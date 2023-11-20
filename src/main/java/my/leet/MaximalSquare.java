package my.leet;

import my.leet.utils.ArrayUtils;

/** 221. 最大正方形 */
public class MaximalSquare {

    /** 动规 出错 */
    static int func(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] left = new int[m+1][n+1];
        int[][] up = new int[m+1][n+1];
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    left[i][j] = left[i][j-1] + 1;
                    up[i][j] = up[i-1][j] + 1;
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    if (left[i][j] > dp[i-1][j-1] && up[i][j] > dp[i-1][j-1]) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = dp[i-1][j-1];
                    }
                } else {
                    dp[i][j] = 0;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }

    /** 标准解法 */
    static int func2(char[][] matrix) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i-1][j-1] == '1') {
                    if (i==1 || j == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    }
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        char[][] matrix = {{'1','1','1','1','1'},{'1','1','1','1','1'},{'0','0','0','0','0'},{'1','1','1','1','1'},{'1','1','1','1','1'}};
//        char[][] matrix = {{'1','0','1','0'},{'1','0','1','1'},{'1','0','1','1'},{'1','1','1','1'}};
        int ans = func(matrix);
        System.out.println(ans);
        ans = func2(matrix);
        System.out.println(ans);
    }
}
