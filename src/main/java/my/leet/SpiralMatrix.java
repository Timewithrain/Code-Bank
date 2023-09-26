package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 54. 螺旋矩阵 */
public class SpiralMatrix {

    static boolean hasNext(int[][] matrix, boolean[][] visited, int i, int j) {  // 判断是否能以当前方向继续向前运行
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
            if (direct==0) j += 1;  // 向前运行
            if (direct==1) i += 1;
            if (direct==2) j -= 1;
            if (direct==3) i -= 1;
            if (!hasNext(matrix, visited, i, j)) {  // 若超过范围或遇到已经访问过的元素则回退一格改变方向继续遍历
                if (direct==0) j -= 1;  // 回退一格
                if (direct==1) i -= 1;
                if (direct==2) j += 1;
                if (direct==3) i += 1;
                direct = (direct+1) % 4;  // 顺时针改变方向
                if (direct==0) j += 1;  // 继续向前
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

    /** 四个方向旋转遍历 */
    static List<Integer> func2(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int up = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[up][i]);
            }
            up++;
            if (up>bottom) break;
            for (int i = up; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (left>right) break;
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            if (up>bottom) break;
            for (int i = bottom; i >= up; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if (left>right) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{6,5,4},{7,8,9}}; // {{1}}; //
//        List<Integer> ans = func(matrix);
        List<Integer> ans = func2(matrix);
        System.out.println(ans);
    }
}
