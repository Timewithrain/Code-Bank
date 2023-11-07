package my.leet;

import java.util.LinkedList;

/** 909. 蛇梯棋 */
public class SnakesAndLadders {

    /** dfs超时 */
    static int dfs(int i, int[] board, int[] visited, int target, int cur, int ans) {
        if (i == (target-1)) return cur;
        if (visited[i] == 1) return Integer.MAX_VALUE;
        if (cur >= ans) return cur;
        visited[i] = 1;
        for (int j = 1; j <= 6; j++) {
            int next = i+j;
            if (next > target-1) break;
            if (board[next] != -1) {
                ans = Math.min(ans, dfs(board[next]-1, board, visited, target, cur+1, ans));
            } else {
                ans = Math.min(ans, dfs(next, board, visited, target, cur+1, ans));
            }
        }
        visited[i] = 0;
        return ans;
    }

    static int func(int[][] board) {
        int ans = 0;
        int n = board.length;
        int[] newBoard = new int[n*n];
        int[] visited = new int[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i%2 == 0) {
                    newBoard[i*n+j] = board[n-1-i][j];
                } else {
                    newBoard[i*n+j] = board[n-1-i][n-1-j];
                }
            }
        }
        ans = dfs(0, newBoard, visited, n*n, 0, Integer.MAX_VALUE);
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }

    /** bfs通过: 超过72.35% */
    static int func2(int[][] board) {
        int ans = -1;
        int n = board.length;
        int[] newBoard = new int[n*n];
        int[] visited = new int[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i%2 == 0) {
                    newBoard[i*n+j] = board[n-1-i][j];
                } else {
                    newBoard[i*n+j] = board[n-1-i][n-1-j];
                }
            }
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == (n*n-1)) {
                ans = cur[1];
                break;
            }
            for (int i = 1; i <= 6; i++) {
                int next = cur[0] + i;
                if (next > n*n-1) break;
                if (newBoard[next] != -1) next = newBoard[next]-1;
                if (visited[next] == 1) continue;
                queue.add(new int[]{next, cur[1]+1});
                visited[next] = 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int[][] board = {{-1,-1},{-1,3}};
        int ans = func2(board);
        System.out.println(ans);
    }
}
