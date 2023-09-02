package my.leet;

public class NumberOfIslands {

    static void search(char[][] grid, int[][] mask, int i, int j, int n) {
        if (i>=grid.length || i<0) return;
        if (j>=grid[i].length || j<0) return;
        if (grid[i][j]=='0' || mask[i][j] != 0) return;
        mask[i][j] = n;
        search(grid, mask, i+1, j, n);
        search(grid, mask, i-1, j, n);
        search(grid, mask, i, j+1, n);
        search(grid, mask, i, j-1, n);
    }

    static int func(char[][] grid) {
        int ans = 0;
        int[][] mask = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]=='1' && mask[i][j] == 0) {
                    search(grid, mask, i, j, ans+1);
                    ans += 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','1','0'}};
        int ans = func(grid);
        System.out.println(ans);

    }
}
