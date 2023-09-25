package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 54. 螺旋矩阵 */
public class SpiralMatrix {

    static boolean hasNext(int[][] matrix, boolean[][] visited, int i, int j) {
        if (i<0 || j <0 || i>=matrix.length || j>=matrix[0].length || visited[i][j]) return false;
        else return true;
    }

    static void fill(int[][] matrix, boolean[][] visited, List<Integer> ans) {
        int i = 0;
        int j = 0;
        int direct = 0;
        while (hasNext(matrix, visited, i, j)) {
            ans.add(matrix[i][j]);
            visited[i][j] = true;
            if (direct==0) j += 1;
            if (direct==1) i += 1;
            if (direct==2) j -= 1;
            if (direct==3) i -= 1;
            if (!hasNext(matrix, visited, i, j)) {
                if (direct==0) j -= 1;
                if (direct==1) i -= 1;
                if (direct==2) j += 1;
                if (direct==3) i += 1;
                direct = (direct+1) % 4;
                if (direct==0) j += 1;
                if (direct==1) i += 1;
                if (direct==2) j -= 1;
                if (direct==3) i -= 1;
            }
        }
    }

    static List<Integer> func(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();
        fill(matrix, visited, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}}; // {{1,2,3},{6,5,4},{7,8,9}}; //
        List<Integer> ans = func(matrix);
        System.out.println(ans);
    }
}
