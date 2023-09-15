package my.exam.didi;

import java.util.Scanner;

/**
 * 给定一个n×m的矩阵，每个位置上的数是0或者1，1代表黑色围栏，0代表空白，若想要从左上角到右下角，穿过最少的围栏，求穿过的围栏数。
 */
/*
5 3
0 1 0
0 1 1
0 1 0
1 0 0
1 0 0
 */
public class BlackWhiteBlock {

    static int func(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + grid[i][j], dp[i][j-1] + grid[i][j]);
            }
        }
        return dp[n-1][m-1];
    }

    static int dfs(int[][] grid, int[][] dp, int i, int j) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length) {
            return Integer.MAX_VALUE;
        }
        dfs(grid, dp, i-1, j);
        dfs(grid, dp, i, j-1);

        return 0;
    }

    static int func2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];


        return 0;
    }




    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        int ans = func(grid);
        System.out.println(ans);
    }
}

