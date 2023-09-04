package my.exam.meituan2;

import java.util.Scanner;

/** 小美的递增数组
 *  给定数组array，如果数组中的元素array[i] > array[i-1]
 *  且定义b[i] = array[i+1] - array[i]，若b[i]<b[i-1] 则称array为合法递增数组。
 *  请判断给定的数组是否为合法递增数组。
 *  通过100%
 */
public class MeiIncreasingArray {

    static boolean func(int[] array) {
        boolean ans = true;
        int pre = array[1] - array[0];
        for (int i = 1; i < array.length; i++) {
            if (i < array.length - 1) {
                if (array[i+1] - array[i] >= pre) {
                    ans = false;
                    break;
                }
                pre = array[i+1] - array[i];
            }
            if (array[i] <= array[i-1]) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        if (func(array)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
