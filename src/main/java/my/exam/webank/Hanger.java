package my.exam.webank;

import java.util.Scanner;

/**
 * 2. 塔吊
 * 给定一个n行m列的矩阵和一个臂长为r的塔吊，矩阵代表一个城市，矩阵上有三种数组，0，1，2
 * 其中0代表空地，可以放置塔吊；1代表楼房，塔吊吊臂范围内不能出现楼房；2待施工的楼房，其必须出现在塔吊吊臂范围内
 * 请问矩阵中有多少个空地可以放置塔吊？
 * 输入：
 * 4 5 2
 * 01000
 * 00010
 * 00200
 * 00001
 * 输出：
 * 2
 * 通过：82%
 */
public class Hanger {

    static int func(int[][] board) {
        int ans = 0;

        return ans;
    }

    static boolean match(int x, int y, int xt, int yt, int r) {
        if (Math.abs(x - xt) + Math.abs(y - yt) <= r) return true;
        return false;
    }

    /** 通过：82% */
    static int func2(int[][] board, int r) {
        int ans = 0;
        int n = board.length;
        int m = board[0].length;
        int xt = 0, yt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    xt = i;
                    yt = j;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    boolean tmp = true;
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (board[k][l] == 1 && Math.abs(i-k) + Math.abs(j-l) <= r) {
                                tmp = false;
                                break;
                            }
                        }
                        if (!tmp) break;
                    }
                    if (tmp && match(i, j, xt, yt, r)) {
                        ans += 1;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int r = in.nextInt();
        in.nextLine();
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }
        int ans = func2(board, r);
        System.out.println(ans);

    }
}
