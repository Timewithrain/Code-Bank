package my.leet;

/** 96. 不同的二叉搜索树 */
public class UniqueBinarySearchTree {

    static int func(int n) {
        if (n<=2) return n;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 19;
        System.out.println(func(n));
    }
}
