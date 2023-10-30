package my.leet;

/** 1139. 最大的以1为边界的正方形 */
public class LargestOneBorderedSquare {

    /** 循环解法 */
    /** 判断是否围成一个正方形 */
    static boolean isSquare(int[][] grid, int x, int y, int len) {
        for (int i = 0; i < len; i++) {
            if (grid[x+i][y]==0 || grid[x+i][y+len-1]==0 || grid[x][y+i]==0 || grid[x+len-1][y+i]==0) {
                return false;
            }
        }
        return true;
    }

    static int func(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int len = Math.min(m, n);
        for (int l = len; l > 0; l--) {
            for (int i = 0; i+l-1 < m; i++) {
                for (int j = 0; j+l-1 < n; j++) {
                    if (isSquare(grid, i, j, l)) {
                        return l*l;
                    }
                }
            }
        }
        return ans;
    }

    /** 标准解法：数组存(x,y)上下左右连续1的最大长度，使用动态规划构造该数组  */
    static int func2(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] up = new int[m+1][n+1];
        int[][] left = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 动态规划， 构造up和left
                if (grid[i-1][j-1] == 1) {
                    up[i][j] = up[i-1][j] + 1;
                    left[i][j] = left[i][j-1] + 1;
                }
                for (int l = Math.min(left[i][j], up[i][j]); l > 0; l--) {
                    // 使用up和left判别
                    if (left[i][j] >= l && up[i][j] >= l && (i-l+1 > 0 && left[i-l+1][j] >= l) && (j-l+1 > 0 && up[i][j-l+1] >= l)) {
                        ans = Math.max(ans, l*l);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,1},{1,1,1},{1,1,1}}; // {{1,1,0,0}}; //
        int ans = func(grid);
        System.out.println(ans);
    }
}
