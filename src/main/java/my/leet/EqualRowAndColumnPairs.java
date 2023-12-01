package my.leet;

import java.util.HashMap;

/** 2352. 相等行列对 */
public class EqualRowAndColumnPairs {

    static int func(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(grid[i][0]);
            for (int j = 1; j < n; j++) {
                sb.append(',').append(grid[i][j]);
            }
            String s = sb.toString();
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for (int j = 0; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            sb.append(grid[0][j]);
            for (int i = 1; i < n; i++) {
                sb.append(',').append(grid[i][j]);
            }
            ans += map.getOrDefault(sb.toString(), 0);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
