package my.exam.dajiang;

/**
 * 大疆笔试题目
 * 灌溉农作物
 * 给定一个二维数组cropField，数组每一个数值代表农作物的产量，
 * 现在需要布置两根灌溉管道，分别从左到右和从上到下，灌溉管道途经的农作物产量能翻倍，但重复灌溉也只能翻倍一次，不能多次翻倍
 * 求如何布置两根管道使农作物产量最大，返回最大农作物产量
 */
public class DaJiangExam {

    public static int func(int[][] cropField) {
        int ans = 0;
        for (int i = 0; i < cropField.length; i++) {
            for (int j = 0; j < cropField[i].length; j++) {
                int tmp = 0;
                for (int m = 0; m < cropField.length; m++) {
                    for (int n = 0; n < cropField[m].length; n++) {
                        tmp += cropField[m][n];
                        if (m==i && n!=j) tmp += cropField[m][n];
                        if (n==j) tmp += cropField[m][n];
                    }
                }
                if (tmp > ans) ans = tmp;
            }
        }
        return ans;
    }

    public static int func2(int[][] cropField) {
        int ans = 0;
        int base = 0;
        for (int i = 0; i < cropField.length; i++) {
            for (int j = 0; j < cropField[i].length; j++) {
                base += cropField[i][j];
                int tmp = 0;
                for (int k = 0; k < cropField.length; k++) {
                    tmp += cropField[k][j];
                }
                for (int k = 0; k < cropField[i].length; k++) {
                    if (k!=j) tmp += cropField[i][k];
                }
                if (tmp > ans) ans = tmp;
            }
        }
        return ans + base;
    }

    public static void main(String[] args) {
//        int[][] cropField = {
//            {2,3,1,4},
//            {1,2,0,3},
//            {4,2,1,7},
//            {3,1,4,2},};
        int[][] cropField = {
                {1,2,3},
                {1,1,3}
        };
        System.out.println(func2(cropField));
    }
}
