package my.leet;

/** 1143. 最长公共子序列 */
public class LongestCommonSubsequence {

    static int func(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, Math.max(dp[i-1][j], dp[i][j-1]));
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String text1 = "abc"; // "abcde"; // "abcde"; //
        String text2 = "def"; // "ace"; // "ace"; //
        System.out.println(func(text1, text2));
    }
}
