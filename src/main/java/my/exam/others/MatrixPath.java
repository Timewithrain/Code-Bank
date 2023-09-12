package my.exam.others;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定一个矩阵，找出从左上到右上角的一条路，使得这条路上数字和最大。
 * 这条路前进的方向有如下限制，第一段只能向右或向下，第二段只能向右或向上。
 * 输入的第一行是矩阵的行数和列数。输出第一行是一个序列，为该条路上的数字，第二行是这些数字的和。
 * 例如：
 * 输入；
 * 3 4
 * 1 1 1 1
 * 2 3 2 2
 * 2 3 4 1
 * 输出：
 * 1 2 3 3 4 2 2 1
 * 18
 */
public class MatrixPath {

    /** 题意理解为奇数行向右向下，偶数行向右向上 */
    static int dfs(int[][] matrix, int i, int j, ArrayList<Integer> path, ArrayList<Integer> ansPath, int cur, int ans, int[][] visited) {
        if (i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j]==1) return Integer.MIN_VALUE;
        visited[i][j] = 1;
        path.add(matrix[i][j]);
        if (i==0 && j==matrix[0].length-1) {
            cur += matrix[i][j];
            if (cur > ans) {
                ans = cur;
                ansPath.clear();
                ansPath.addAll(path);
            }
        } else {
            if (i%2==0) {
                ans = Math.max(ans, dfs(matrix, i, j+1, path, ansPath, cur+matrix[i][j], ans, visited));
                ans = Math.max(ans, dfs(matrix, i+1, j, path, ansPath, cur+matrix[i][j], ans, visited));
            } else {
                ans = Math.max(ans, dfs(matrix, i, j+1, path, ansPath, cur+matrix[i][j], ans, visited));
                ans = Math.max(ans, dfs(matrix, i-1, j, path, ansPath, cur+matrix[i][j], ans, visited));
            }
        }
        path.remove(path.size()-1);
        visited[i][j] = 0;
        return ans;
    }

    /** 题意理解为向右向下直到最底端为第一段，向右向上直到目标位置为第二段 */
    static int dfs2(int[][] matrix, int i, int j, int direct,  ArrayList<Integer> path, ArrayList<Integer> ansPath, int ans, int[][] visited) {
        if (i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || visited[i][j]==1) return Integer.MIN_VALUE;
//        visited[i][j] = 1;
        path.add(matrix[i][j]);
        if (i==0 && j==matrix[0].length-1) {
            int cur = 0;
            for (int k = 0; k < path.size(); k++) {
                cur += path.get(k);
            }
            if (cur > ans) {
                ans = cur;
                ansPath.clear();
                ansPath.addAll(path);
            }
        } else {
            if (direct==1 || i==matrix.length-1) {
                ans = Math.max(ans, dfs2(matrix, i, j+1, 1, path, ansPath, ans, visited));
                ans = Math.max(ans, dfs2(matrix, i-1, j, 1, path, ansPath, ans, visited));
            } else {
                ans = Math.max(ans, dfs2(matrix, i+1, j, 0, path, ansPath, ans, visited));
                ans = Math.max(ans, dfs2(matrix, i, j+1, 0, path, ansPath, ans, visited));
            }

        }
        path.remove(path.size()-1);
        visited[i][j] = 0;
        return ans;
    }

    static void func(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int ans = Integer.MIN_VALUE;
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<Integer>  ansPath = new ArrayList<>();
        ans = dfs2(matrix, 0, 0, 0, path, ansPath, ans, visited);
        for (int i = 0; i < ansPath.size(); i++) {
            System.out.printf("%d ", ansPath.get(i));
        }
        System.out.println();
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {  // 输入矩阵
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        func(matrix);
    }
}
