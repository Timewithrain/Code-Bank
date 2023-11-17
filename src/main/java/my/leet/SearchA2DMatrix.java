package my.leet;

/** 74. 搜索二维矩阵 */
public class SearchA2DMatrix {

    static int getMat(int[][] matrix, int i) {
        int c = matrix[0].length;
        return matrix[i/c][i%c];
    }

    static boolean func(int[][] matrix, int target) {
        boolean ans = false;
        int row = matrix.length;
        int col = matrix[0].length;
        int l = 0, r = row * col - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (getMat(matrix, mid) == target) {
                ans = true;
                break;
            } else if (getMat(matrix, mid) < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 16;
        boolean ans = func(matrix, target);
        System.out.println(ans);
    }
}
