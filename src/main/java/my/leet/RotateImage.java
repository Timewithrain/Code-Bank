package my.leet;

import my.leet.utils.ArrayUtils;

/** 48. 旋转图像 */
public class RotateImage {

    static void swap(int[][] nums, int i, int j, int x, int y) {
        int tmp = nums[i][j];
        nums[i][j] = nums[x][y];
        nums[x][y] = tmp;
    }

    static void func(int[][] matrix) {
        int n = matrix.length;
        // 转置
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        // 左右翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n/2; j++) {
                swap(matrix, i, j ,i, n-j-1);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1}}; // {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}}; // {{1,2,3},{4,5,6},{7,8,9}}; //
        func(matrix);
        ArrayUtils.printArray(matrix);
    }
}
