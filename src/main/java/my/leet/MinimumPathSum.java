package my.leet;

/** 64. 最小路径和 */
public class MinimumPathSum {

    /** 深搜超时 */
    static int dfs(int[][] grid, int gi, int gj, int cur, int ans) {
        if (gi >= grid.length || gj >= grid[gi].length) return Integer.MAX_VALUE;
        cur += grid[gi][gj];
        if (gi==grid.length-1 && gj==grid[gi].length-1) return Math.min(cur, ans);
        ans = Math.min(ans, dfs(grid, gi+1, gj, cur, ans));
        ans = Math.min(ans, dfs(grid, gi, gj+1, cur, ans));
        return ans;
    }

    static int func(int[][] grid) {
        int ans = dfs(grid, 0, 0, 0, Integer.MAX_VALUE);
        return ans;
    }

    /** 动态规划 */
    static int func2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,2,3},{4,5,6}}; // {{1,3,1},{1,5,1},{4,2,1}}; //  {{1,3,1},{1,5,1},{4,2,1}}; //
        System.out.println(func2(grid));
    }
}
