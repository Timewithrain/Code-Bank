package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 51. N皇后*/
public class NQueenProblem {

    static List<String> addBoard(int[][] board) {
        List<String> t = new ArrayList<>();
        for (int k = 0; k < board.length; k++) {
            StringBuilder sb = new StringBuilder();
            for (int l = 0; l < board[k].length; l++) {
                if (board[k][l]==-1) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            t.add(sb.toString());
        }
        return t;
    }

    static void occupy(int[][] board, int i, int j) {
        board[i][j] = -1;
        int h = j ;
        int v = i;
        for (int k = 0; k < board.length; k++) {
            if (k!=i && board[k][j]!=-1) board[k][j] += 1;
            if (k!=j && board[i][k]!=-1) board[i][k] += 1;
        }
        for (int k = 1; k < board.length-i; k++) {
            if (j+k < board.length && board[i+k][j+k]!=-1) board[i+k][j+k] += 1;
            if (j-k >= 0 && board[i+k][j-k]!=-1) board[i+k][j-k] += 1;
        }
        for (int k = 1; k <= i; k++) {
            if (j-k >= 0 && board[i-k][j-k]!=-1) board[i-k][j-k] += 1;
            if (j+k < board.length && board[i-k][j+k]!=-1) board[i-k][j+k] += 1;
        }
    }

    static void deOccupy(int[][] board, int i, int j) {
        board[i][j] = 0;
        int h = j ;
        int v = i;
        for (int k = 0; k < board.length; k++) {
            if (k!=i && board[k][j]!=-1) board[k][j] -= 1;
            if (k!=j && board[i][k]!=-1) board[i][k] -= 1;
        }
        for (int k = 1; k < board.length-i; k++) {
            if (j+k < board.length && board[i+k][j+k]!=-1) board[i+k][j+k] -= 1;
            if (j-k >= 0 && board[i+k][j-k]!=-1) board[i+k][j-k] -= 1;
        }
        for (int k = 1; k <= i; k++) {
            if (j-k >= 0 && board[i-k][j-k]!=-1) board[i-k][j-k] -= 1;
            if (j+k < board.length && board[i-k][j+k]!=-1) board[i-k][j+k] -= 1;
        }
    }

    static void dfs(int[][] board, int p, int q, int n, List<List<String>> ans) {
        if (n==0) {
            ans.add(addBoard(board));
            return;
        }
        for (int i = p; i < board.length; i++) {
            int j = 0;
            if (i==p) j = q;
            for (; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    occupy(board, i, j);
                    dfs(board, i, j, n-1, ans);
                    deOccupy(board, i, j);
                }
            }
        }
    }

    static List<List<String>> func(int n) {
        int[][] board = new int[n][n];
        List<List<String>> ans = new ArrayList<>();
        dfs(board, 0, 0, n, ans);
        return ans;
    }

    static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        int n = 4;
        List<List<String>> ans = func(n);
        System.out.println(ans.size());
//        int ans = NQueenProblemII.func(n);
//        System.out.println(ans);
    }
}

/** 52. N皇后问题II */
class NQueenProblemII {

    static void occupy(int[][] board, int i, int j) {
        board[i][j] = -1;
        int h = j ;
        int v = i;
        for (int k = 0; k < board.length; k++) {
            if (k!=i && board[k][j]!=-1) board[k][j] += 1;
            if (k!=j && board[i][k]!=-1) board[i][k] += 1;
        }
        for (int k = 1; k < board.length-i; k++) {
            if (j+k < board.length && board[i+k][j+k]!=-1) board[i+k][j+k] += 1;
            if (j-k >= 0 && board[i+k][j-k]!=-1) board[i+k][j-k] += 1;
        }
        for (int k = 1; k <= i; k++) {
            if (j-k >= 0 && board[i-k][j-k]!=-1) board[i-k][j-k] += 1;
            if (j+k < board.length && board[i-k][j+k]!=-1) board[i-k][j+k] += 1;
        }
    }

    static void deOccupy(int[][] board, int i, int j) {
        board[i][j] = 0;
        for (int k = 0; k < board.length; k++) {
            if (k!=i && board[k][j]!=-1) board[k][j] -= 1;
            if (k!=j && board[i][k]!=-1) board[i][k] -= 1;
        }
        for (int k = 1; k < board.length-i; k++) {
            if (j+k < board.length && board[i+k][j+k]!=-1) board[i+k][j+k] -= 1;
            if (j-k >= 0 && board[i+k][j-k]!=-1) board[i+k][j-k] -= 1;
        }
        for (int k = 1; k <= i; k++) {
            if (j-k >= 0 && board[i-k][j-k]!=-1) board[i-k][j-k] -= 1;
            if (j+k < board.length && board[i-k][j+k]!=-1) board[i-k][j+k] -= 1;
        }
    }

    static int dfs(int[][] board, int p, int q, int n, int ans) {
        if (n==0) {
            return ans + 1;
        }
        for (int i = p; i < board.length; i++) {
            int j = 0;
            if (i==p) j = q;
            for (; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    occupy(board, i, j);
                    ans = dfs(board, i, j, n-1, ans);
                    deOccupy(board, i, j);
                }
            }
        }
        return ans;
    }

    static int func(int n) {
        int[][] board = new int[n][n];
        int ans = dfs(board, 0, 0, n, 0);
        return ans;
    }
}
