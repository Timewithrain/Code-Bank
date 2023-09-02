package my.leet.mihayo;

public class NQueenProblem {

    /** 对棋盘进行occupy和取消occupy操作，棋盘格中值为0为空白格，值为1为皇后影响范围，置为-1为皇后所在的位置 */
    static void option(int board[][], int i, int j, int opt) {
        board[i][j] = opt==1 ? -1 : 0;  // 若opt为1，则
        for (int m = 0; m < board.length; m++) {
            if (m==i) continue;
            if (board[m][j]!=-1) board[m][j] += opt;  // 纵向影响范围
            if (0 <= i+j-m && i+j-m < board[m].length && board[m][i+j-m] != -1) board[m][i+j-m] += opt;  // 斜率k=1影响范围
        }
        for (int m = 0; m < board[i].length; m++) {
            if (m==j) continue;
            if (board[i][m] != -1) board[i][m] += opt;  // 横向影响范围
            if (0 <= i-j+m && i-j+m < board.length && board[m+i-j][m] != -1 ) board[m+i-j][m] += opt;  // 斜率k=-1影响范围
        }
    }

    static int dfs(int board[][], int x, int y, int n, int ans) {
        if (n==0) {
            return ans+1;
        }
        for (int i = x; i < board.length; i++) {
            int j = 0;
            if (i==x) j = y;
            for (; j < board[i].length; j++) {
                if (board[i][j]==0) {
                    option(board, i, j, 1);
                    ans = dfs(board, i, j, n-1, ans);
                    option(board, i, j, -1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 8;
        int[][] board = new int[n][n];
        int ans = 0;
        ans = dfs(board, 0, 0, n, ans);
        System.out.println(ans);
    }

}
