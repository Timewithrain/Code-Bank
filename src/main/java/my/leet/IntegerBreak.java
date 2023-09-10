package my.leet;

/** 343. 整数拆分 */
public class IntegerBreak {

    static int func(int n) {
        int[] dp = new int[n+1];  // 记录n[i]能够拆分后求积得到的最大值
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                int newBreak = Math.max(dp[i-j] * dp[j], dp[i-j] * j);  // 选择继续拆分两个子项，或仅拆分子项中的一个
                newBreak = Math.max(newBreak, (i-j) * j);  // 选择不拆分两个子项
                dp[i] = Math.max(dp[i], newBreak);  // 更新拆分结果
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n =  2; // 10;  //
        System.out.println(func(n));
    }
}
