package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.HashSet;

/** 73. 矩阵置零 */
public class SetMatrixZeros {

    static void func(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> row = new HashSet<>();
        HashSet<Integer> col = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for (Integer i : row) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer i : col) {
            for (int j = 0; j < m; j++) {
                matrix[j][i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}}; // {{0,1,2,0},{3,4,5,2},{1,3,1,5}}; //
        func(matrix);
        ArrayUtils.printArray(matrix);
    }
}
