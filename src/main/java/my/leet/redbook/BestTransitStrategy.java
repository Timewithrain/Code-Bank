package my.leet.redbook;

/**
 * 给定一系列山峰的高度数组mountains和一个传送门k，要求找出从第1座山峰走到第n座山峰所需要的花费
 * 传送门k的含义，能从当前山峰i跳到i+1至i+k的任意一座山峰
 * 传送门有花费，假设要从第i座山峰跳到第j座山峰，若第i座山峰高度大于第j座的高度则花费为0，否则花费为第j座高度-第i座的高度
 */
public class BestTransitStrategy {

    static int dp(int[] mountains, int k) {
        int[] dp = new int[mountains.length];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i-j >= 0) {
                    int tmp = mountains[i-j] > mountains[i] ? dp[i-j] : dp[i-j] + (mountains[i] - mountains[i-j]);
                    min = Math.min(min, tmp);
                }
            }
            dp[i] = min;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] mountains = {1,2,3,4,5};
        int k = 2;
        int ans = dp(mountains, k);
        System.out.println(ans);
    }
}
