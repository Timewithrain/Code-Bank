package my.leet;

/** 516. 最长回文子序列 */
public class LongestPalindromicSubsequence {

    static int func(String s) {
        int l = s.length();
        if (l==1) return 1;
        int[][] dp = new int[l][l];
        dp[0][0] = 1;
        dp[0][1] = s.charAt(0)==s.charAt(1) ? 2 : 1;
        for (int j = 1; j < l; j++) {
            dp[j][j] = 1;
            for (int i = j-1; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = j-i>1 ? dp[i+1][j-1] + 2 : 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][l-1];
    }

    public static void main(String[] args) {
        String s = "abcbca";
        System.out.println(func(s));
    }
}
