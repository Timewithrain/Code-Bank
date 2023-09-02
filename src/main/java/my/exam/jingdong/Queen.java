package my.exam.jingdong;

import java.util.Scanner;

/**
 * 京东2024校招笔试题
 * 3.皇后问题
 * 小红将皇后从棋盘左上角移动到右下角，皇后可以作三种操作：右移n格(i+1)、下移n格(j+1)、右下移n格(i+1,j+1)
 * 棋盘格中包含障碍，遇到障碍无法穿越，求小红将皇后移动到右下角的最少操作数，若无法到达输出-1
 *
 * -------用例1:
 * 输入:
 * 3 3
 * ...
 * ***
 * ...
 * 输出:
 * -1
 * -------用例2:
 * 输入:
 * 3 4
 * ....
 * **.*
 * ....
 * 输出:
 * 2
 */
public class Queen {

    static int func(char[][] board, int[][] mask, int i, int j, int d, int n) {
        if (i== board.length-1 && j==board[i].length-1) return n;
        if (i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]=='*') return Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        if (mask[i][j] == 0) {
            mask[i][j] = 1;
            ans = Math.min(ans, func(board, mask, i+1, j, 1, d==1?n:n+1));
            ans = Math.min(ans, func(board, mask, i, j+1, 2, d==2?n:n+1));
            ans = Math.min(ans, func(board, mask, i+1, j+1, 3, d==3?n:n+1));
            mask[i][j] = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] board = new char[n][m];
        int[][] mask = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }
        int ans = func(board, mask, 0, 0, 0, 0);
        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }
}
