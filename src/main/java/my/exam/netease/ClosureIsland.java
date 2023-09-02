package my.exam.netease;

/**
 * 闭合岛屿
 * 给定一个二维数组，其中1代表海洋，0代表陆地，如果一个岛屿完全被1包围，则称为闭合岛屿，求闭合岛屿的数量
 * 通过100%
 */
public class ClosureIsland {

    static void dfs(int[][] grid, int[][] mask, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == 1 || mask[i][j] == 1) return;
        mask[i][j] = 1;  // 将mask置为1，表示已经访问过
        dfs(grid, mask, i + 1, j);
        dfs(grid, mask, i - 1, j);
        dfs(grid, mask, i, j+1);
        dfs(grid, mask, i, j-1);
    }

    public int closedIsland (int[][] grid) {
        int[][] mask = new int[grid.length][grid[0].length];
        int count = 0;
        // 删除四周边缘的陆地将其mask置为1，这样剩下的陆地就是闭合岛屿
        for (int i = 0; i < grid.length; i++) {
            dfs(grid, mask, i, 0);
            dfs(grid, mask, i, grid[i].length - 1);
        }
        for (int i = 0; i < grid[0].length; i++) {
            dfs(grid, mask, 0, i);
            dfs(grid, mask, grid.length-1, i);
        }
        // 查询闭合岛屿的数量
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                if (grid[i][j] == 0 && mask[i][j] == 0) {
                    dfs(grid, mask, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){

    }
}
