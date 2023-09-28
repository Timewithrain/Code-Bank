package my.exam.netease2;

import java.util.Scanner;

public class SumOfSubsequenceAverage {

    static long func(int[] array) {
        long ans = 0;
        long mod = 1000000007;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long)array[i] * (i+1) % mod * (n-i) % mod) % mod;
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
        long ans = func(array);
        System.out.println(ans);
    }
}
