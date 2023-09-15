package my.exam.shein;

import java.util.Scanner;

/**
 * 小明使用令牌桶存储令牌，每100ms产生10个令牌，桶内最多存储150个令牌，每个请求需要消耗1个令牌，如果令牌不足，则请求被拒绝。
 * 500ms后请求超时，不再消耗令牌。
 * 初始桶内包含100个令牌，请求n次后，被拒绝请求的次数为多少？
 * 输入一个n，接着n排，每排两个数，第一个数表示请求时间，第二个数表示请求次数。
 * 输入；
 * 2
 * 100 200
 * 100 20
 * 输出；
 * 100
 *
 */
public class RestrictStream {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] t = new int[n];
        int[] request = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
            request[i] = in.nextInt();
        }
        int buket = 100;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            buket += (t[i]/100) * 10;
            buket = Math.min(buket, 150);
            if (buket < request[i]){
                ans += request[i] - buket;
                buket = 0;
            } else {
                buket = buket - request[i];
            }
        }
        System.out.println(ans);
    }
}
