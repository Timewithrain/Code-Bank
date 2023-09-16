package my.exam.didi;

import java.util.Scanner;

/**
 * 给定一个n×m的矩阵，每个位置上的数是0或者1，1代表黑色围栏，0代表空白，若想要从左上角到右下角穿过最少的围栏，求穿过的围栏数。
 */
public class BlackWhiteBlock {

    /** 动态规划，仅考虑向下向右，通过： 45% */
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

    /** 深搜，考虑四个方向 */
    static int dfs(int[][] grid, int[][] visited, int i, int j, int ans) {
        if (i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] == 1) {
            return Integer.MAX_VALUE;  // 越界或者已经访问过，返回最大值
        }
        if (i==grid.length-1 && j==grid[0].length-1) {  // 到目标点返回0，滤除初始化时的Integer.MAX_VALUE
            return 0;
        }
        visited[i][j] = 1;
        ans = Math.min(ans, dfs(grid, visited, i+1, j, ans));  // 深搜四个方向
        ans = Math.min(ans, dfs(grid, visited, i, j+1, ans));
        ans = Math.min(ans, dfs(grid, visited, i-1, j, ans));
        ans = Math.min(ans, dfs(grid, visited, i, j-1, ans));
        if (grid[i][j] == 1) {  // 回溯时，当前位置是黑色围栏，ans+1
            ans++;
        }
        visited[i][j] = 0;
        return ans;
    }

    static int func2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int ans = dfs(grid, visited, 0, 0, Integer.MAX_VALUE);
        return ans;
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
        int ans = func2(grid);
        System.out.println(ans);
    }
}

/*
5 5
0 1 0 1 0
0 1 0 1 0
0 1 0 1 0
0 1 0 0 0
0 0 0 1 0
输出：
0
输入用例：
5 3
0 1 0
0 1 1
0 1 0
1 0 0
1 0 0
输出：
1
 */
