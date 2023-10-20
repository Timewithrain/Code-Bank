package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.Arrays;

/** 289. 生命游戏 */
public class GameOfLife {

    static int count(int[][] board, int m, int n) {
        int ans = 0;
        for (int i = m-1; i <= m+1; i++) {
            for (int j = n-1; j <= n+1; j++) {
                if (i<0 || i>=board.length || j < 0 || j>=board[0].length || (i==m && j==n)) continue;
                if (board[i][j] == 1) ans++;
            }
        }
        return ans;
    }

    static void func(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            copy[i] = Arrays.copyOf(board[i], board[i].length);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int cnt = count(copy, i, j);
                if (cnt<2 || cnt > 3) {
                    board[i][j] = 0;
                } else if (cnt==3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        func(board);
        ArrayUtils.printArray(board);
    }
}
