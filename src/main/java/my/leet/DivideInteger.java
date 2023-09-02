package my.leet;

/**
 * 343. Integer Break
 * 整数拆分
 */
public class DivideInteger {

    // 参考答案，数学计算
    public static int integerBreakStandard(int n) {
        if (n <= 3) return n-1;
        int a = n/3;
        int b = n%3;
        if (b == 0) return (int)Math.pow(3, a);
        if (b == 1) return (int)Math.pow(3, a-1)*4;
        return (int)Math.pow(3, a)*2;
    }

    public static int integerBreak(int n) {
        if (n<3) {
            return 1;
        } else if (n==3) {
            return 2;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for(int i=4; i<=n; i++) {
            for(int j=1; j<=i/2; j++) {
                dp[i] = Math.max(dp[i], j*(i-j));
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 11;
        System.out.println(integerBreak(n));
    }
}
