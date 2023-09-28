package my.exam.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 项目管理
 * 给定一个数组A代表公司内部n位同事的能力，一个m代表项目的难度。
 * 要求组建一些小组同时完成这个难度位m的项目，当组员个数k乘以最内最强者的能力max大于m时，该小组可以处理这个项目
 * 求最多可以分出多少组同时处理该项目
 * 输入：
 * 3 5
 * 1 2 5
 * 输出：
 * 1
 * 输入：
 * 5 100
 * 121 63 45 51 34
 * 输出：
 * 3
 * 通过：100%
 */
public class ProjectManagement {

    /** 贪心法 */
    static int func(Integer[] A, int m) {
        int ans = 0;
        int l = A.length;
        Arrays.sort(A, (a, b) -> b - a);  // 按处理能力降序排序
        int i = 0;
        for (; i < l; i++) {  // 找出能够单独处理项目的人，作为独立分组
            if (A[i] >= m) {
                ans++;
            } else {
                break;
            }
        }
        int j = l - 1;
        while (i < j) {
            int n = (int) Math.ceil(m / (double)A[i]);  // 以剩余人中能力最强者建组，该组最少需要n个人
            while (n > 1 && j > i) {  // 将能力最弱的人分入该组，直到组员个数达到n
                j--;
                n--;
            }
            if (n==1 && j>=i) {  // 若能够找到n-1个人与第i个人构成n人组，则ans+1
                i++;
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Integer[] A = new Integer[n];
        for (int i = 0; i < n; i++) {
            A[i] = in.nextInt();
        }
        int ans = func(A, m);
        System.out.println(ans);

    }
}
