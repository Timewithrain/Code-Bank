package my.leet;

import my.leet.utils.ArrayUtils;

/** 130. 被围绕的区域 */
public class SurroundedRegions {

    static void dfs(char[][] board, int[][] mask, int i, int j) {
        if (i<0 || i>= board.length || j<0 || j>=board[0].length || mask[i][j]==1 || board[i][j]=='X') return;
        if (board[i][j]=='O') {
            mask[i][j] = 1;
            dfs(board, mask, i+1, j);
            dfs(board, mask, i-1, j);
            dfs(board, mask, i, j+1);
            dfs(board, mask, i, j-1);
        }
    }

    static void func(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] mask = new int[m][n];
        // 将边缘部分'O'对应的mask设置为1
        for (int i = 0; i < m; i++) {
            dfs(board, mask, i, 0);
            dfs(board, mask, i, n-1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, mask, 0, i);
            dfs(board, mask, m-1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]=='O' && mask[i][j]==0) {  // 当board[i][j]为'O'且mask[i][j]为0时(非边缘'O')，置为'X'
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X'}}; // {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}}; //
        func(board);
        ArrayUtils.printArray(board);
    }
}
