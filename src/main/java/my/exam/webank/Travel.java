package my.exam.webank;

import my.leet.utils.ArrayUtils;

import java.util.Scanner;

/**
 * 1. 旅行
 * 给定n个城市和m条道路，想要从A城市到B城市，可以从m条道路中选择部分通过，每条道路的经过代价为cost_i
 * 另有C城市和D城市，其中包含传送门，二者相互传送不需要代价，求从A到B的最小路径代价
 * 输入描述：
 * 第一行n和m
 * 第二行A和B的位置
 * 第三行C和D的位置
 * 接下来m行，输入u v c，其中u和v代表道路方向从u到v，c代表道路的代价
 * 输入：
 * 4 3
 * 1 4
 * 3 4
 * 1 2 1
 * 2 3 1
 * 2 4 2
 * 输出：
 * 2
 * 通过：82%
 */
public class Travel {

    static int dfs(int[][] cost, int[] visited, int pos, int C, int D, boolean flag, int target, int curCost) {
        if (visited[pos]==1) return Integer.MAX_VALUE / 2;
        if (pos == target) return curCost;
        int m = cost.length;
        int ans = Integer.MAX_VALUE / 2;
        if (flag && pos == C) {
            visited[pos] = 1;
            ans = Math.min(ans, dfs(cost, visited, D, C, D, false, target, curCost));
            visited[pos] = 0;
        }
        if (flag && pos == D) {
            visited[pos] = 1;
            ans = Math.min(ans, dfs(cost, visited, C, C, D, false, target, curCost));
            visited[pos] = 0;
        }
        for (int j = 0; j < m; j++) {
            if (cost[j][0]!=pos) continue;
            visited[pos] = 1;
            int tmp = dfs(cost, visited, cost[j][1], C, D, flag, target, curCost + cost[j][2]);
            ans = Math.min(ans, tmp);
            visited[pos] = 0;
        }
        return ans;
    }

    static int func(int[][] cost, int maxPos, int A, int B, int C, int D) {
        int[] visited = new int[maxPos+1];
        int ans = dfs(cost, visited, A, C, D, true, B, 0);
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();
        int C = in.nextInt();
        int D = in.nextInt();
        int[][] cost = new int[m][3];
        int maxPos = 0;
        for (int i = 0; i < m; i++) {
            cost[i][0] = in.nextInt();
            cost[i][1] = in.nextInt();
            cost[i][2] = in.nextInt();
            maxPos = Math.max(maxPos, Math.max(cost[i][0], cost[i][1]));
        }
        int ans = func(cost, maxPos, A, B, C, D);
        System.out.println(ans);
    }
}
