package my.leet;

import my.leet.utils.ArrayUtils;

/** 59. 螺旋矩阵II */
public class SpiralMatrixII {

    static void fill(int[][] ans, int i, int j, int direct, int step, int len, int cur, int n) {
        if (cur > n*n) return;
        if (step > 0) {
            ans[i][j] = cur++;
            step--;
            if (direct==0 && step > 0) j += 1;
            if (direct==1 && step > 0) i += 1;
            if (direct==2 && step > 0) j -= 1;
            if (direct==3 && step > 0) i -= 1;
        } else {
            direct = (direct + 1) % 4;
            if (direct==0) {
                len = n - 2 * i;
                step = len;
            } else {
                step = len - 1;
            }
            if (direct==0) j += 1;
            if (direct==1) i += 1;
            if (direct==2) j -= 1;
            if (direct==3) {
                i -= 1;
                step--;
            }
        }
        fill(ans, i, j, direct, step, len, cur, n);  // 尾递归优化
    }

    static int[][] func(int n) {
        int[][] ans = new int[n][n];
        fill(ans, 0, 0, 0, n, n, 1, n);
        return ans;
    }

    /** 四个方向旋转遍历 */
    static int[][] func2(int n) {
        int[][] ans = new int[n][n];
        int up = 0, bottom = n - 1;
        int left = 0, right = n -1;
        int cur = 1;
        while (cur <= n*n) {
            for (int i = left; i <= right; i++) ans[up][i] = cur++;
            if (++up > bottom) break;
            for (int i = up; i <= bottom; i++) ans[i][right] = cur++;
            if (--right < left) break;
            for (int i = right; i >= left; i--) ans[bottom][i] = cur++;
            if (--bottom < up) break;
            for (int i = bottom; i >= up; i--) ans[i][left] = cur++;
            if (++left > right) break;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
//        int[][] ans = func(n);
        int[][] ans = func2(n);
        ArrayUtils.printArray(ans);
    }
}
