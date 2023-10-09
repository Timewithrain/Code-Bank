package my.exam.tuhu;

/**
 * 1. 从左上角到右下角的最小路径和
 * 通过96.67%
 */
public class BestCarryCost {

    public static int dfs(int[][] grid, int[][] visited, int x, int y, int cost) {
        if (x<0 || x==grid.length || y<0 || y==grid[0].length || visited[x][y]==1) return Integer.MAX_VALUE;
        if (x == grid.length-1 && y == grid[0].length-1) return cost + grid[x][y];
        int ans = Integer.MAX_VALUE;
        visited[x][y] = 1;
        ans = Math.min(ans, dfs(grid, visited, x+1, y, cost+grid[x][y]));
        ans = Math.min(ans, dfs(grid, visited, x, y+1, cost+grid[x][y]));
        visited[x][y] = 0;
        return ans;
    }

    public static int minPathSum (int[][] grid) {
        int ans = Integer.MAX_VALUE / 2;
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        ans = dfs(grid, visited, 0, 0, 0);
        return ans;
    }

    public static void main(String[] args){
        int[][] grid = {{1,2},{1,1}}; // {{1,3,1},{1,5,1},{4,2,1}};
        int ans = minPathSum(grid);
        System.out.println(ans);

    }
}
