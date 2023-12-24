package my.leet;

import java.util.LinkedList;

/** 994. 腐烂的橘子 */
public class RottingOranges {

    static int func(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        int[] tag = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        queue.add(tag);
        while (queue.size() > 1) {
            int[] node = queue.poll();
            if (node == tag) {
                ans++;
                queue.add(node);
            } else {
                int x = node[0], y = node[1];
                if (x>0 && grid[x-1][y] == 1) {queue.add(new int[]{x-1, y}); grid[x-1][y] = 2;}
                if (x<m-1 && grid[x+1][y] == 1) {queue.add(new int[]{x+1, y}); grid[x+1][y] = 2;}
                if (y>0 && grid[x][y-1] == 1) {queue.add(new int[]{x, y-1}); grid[x][y-1] = 2;}
                if (y<n-1 && grid[x][y+1] == 1) {queue.add(new int[]{x, y+1}); grid[x][y+1] = 2;}
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return ans;
    }

    public static void main(String[] args){

    }
}
