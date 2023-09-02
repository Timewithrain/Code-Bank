package my.exam.mihoyo;

import java.util.Scanner;

/**
 * 给定一个四边相接的无限棋盘（左边和右边相连，上边和下边相连），给定三个点pos1, pos2, pos3
 * 现可以向上下左右四个方向移动，求从pos1到pos2的最短路程，在求从pos2到pos3的最短路程
 * 例如:
 * 输入:
 * 3 3
 * 1 1
 * 3 3
 * 1 3
 * 输出:
 * 3
 */
public class Exam1 {

    static int dfs(int[][] mask, int i, int j, int[] pos, int k, int ans) {
        if (mask[i][j]==1 || k > ans) return ans;  // 终止条件
        if (i==pos[0] && j==pos[1]) {
            return k;
        }
        int li = mask.length;
        int lj = mask[i].length;
        mask[i][j] = 1;
        ans = Math.min(ans, dfs(mask, (i+1)%li, j, pos, k+1, ans));
        ans = Math.min(ans, dfs(mask, i-1<0 ? i-1+li : i-1, j, pos, k+1, ans));
        ans = Math.min(ans, dfs(mask, i, (j+1)%lj, pos, k+1, ans));
        ans = Math.min(ans, dfs(mask, i, j-1<0 ? j-1+lj : j-1, pos, k+1, ans));
        mask[i][j] = 0;
        return ans;
    }

    static int func(int[][] mask, int[][] pos) {
        int a = Integer.MAX_VALUE;
        int ans = 0;
        ans = dfs(mask, pos[0][0], pos[0][1], pos[1], 0, a);
        ans += dfs(mask, pos[1][0], pos[1][1], pos[2], 0, a);
        return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] mask = new int[n][m];
        int[][] pos = new int[3][2];
        for (int i = 0; i < 3; i++) {
            pos[i][0] = in.nextInt()-1;
            pos[i][1] = in.nextInt()-1;
        }
        System.out.println(func(mask, pos));
    }


}
