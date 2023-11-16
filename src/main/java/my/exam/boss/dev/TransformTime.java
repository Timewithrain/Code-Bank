package my.exam.boss.dev;

import java.util.Scanner;

/** 2. 转换次数
 * 给定一个数n，将其转换为其每个数位上的数的乘积，问转换多少次后n变为一位数？
 * 输入：
 * 285
 * 输出：
 * 2
 */
public class TransformTime {

    static int func(int n) {
        int ans = 0;

        while (n > 9) {
            int tmp = 1;
            while (n > 0) {
                tmp *= n % 10;
                n = n / 10;
            }
            n = tmp;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = func(n);
        System.out.println(ans);
    }
}
