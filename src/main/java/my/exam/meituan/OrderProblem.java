package my.exam.meituan;

import java.util.Scanner;

/**
 * 给定q个询问，每个询问包含两个整数m和x
 * x为订单的计数，最小值为1，最大值为m，若x>m，则重置x为1
 * 通过100%
 */
public class OrderProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        int[] m = new int[q];
        int[] x = new int[q];
        for (int i = 0; i < q; i++) {
            m[i] = in.nextInt();
            x[i] = in.nextInt();
        }
        for (int i = 0; i < q; i++) {
            System.out.println((x[i]-1)%m[i] + 1);
        }
    }
}
