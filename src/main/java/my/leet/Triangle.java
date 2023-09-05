package my.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 120. 三角形最小路径和 */
public class Triangle {

    static int func(List<List<Integer>> triangle) {
        int l = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[l][l];
        dp[0][0] = triangle.get(0).get(0);
        if (l == 1) return dp[0][0];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                int up = j < i ? dp[i-1][j] : Integer.MAX_VALUE;
                int up_left = j>0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(up, up_left) + row.get(j);
                if (i == triangle.size()-1) {
                    ans = Math.min(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3,4)));
        triangle.add(new ArrayList<>(Arrays.asList(6,5,7)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,8,3)));
        System.out.println(func(triangle));
    }
}
