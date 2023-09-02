package my.leet.redbook;

/**
 * 有ABCD四种零件，其质量大于x被判定为合格，由合格的四种零件各出其一可以拼成一个完整的产品
 * 当有一堆ABCD零件后，请求出最多能拼成多少个完整的产品
 */
public class ComponentAssemble {

    static int func(int[] A, int[] B, int[] C, int[] D, int x) {

        int cntA = 0, cntB = 0, cntC = 0, cntD = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= x) cntA++;
        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] >= x) cntB++;
        }
        for (int i = 0; i < C.length; i++) {
            if (C[i] >= x) cntC++;
        }
        for (int i = 0; i < D.length; i++) {
            if (D[i] >= x) cntD++;
        }
        return Math.min(Math.min(cntA, cntB), Math.min(cntC, cntD));
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {2, 3, 4, 5, 6};
        int[] C = {3, 4, 5, 6, 7};
        int[] D = {4, 5, 6, 7, 8};
        int x = 4;
        System.out.println(func(A, B, C, D, x));
    }
}
