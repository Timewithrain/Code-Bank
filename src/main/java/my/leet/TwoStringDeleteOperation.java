package my.leet;

/**
 * 583. 两个字符串的删除操作
 */
public class TwoStringDeleteOperation {

    /** 动态规划 */
    static int dp(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // dp数组初始化
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = word2.length();
        }
        for (int i = 0; i < word2.length(); i++) {
            dp[0][i] = word1.length();
        }
        // 动态规划推理结果
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]);
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+2);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1 = "leetcode";
        String word2 = "etco";
        int ans = dp(word1, word2);
        System.out.println(ans);
    }

}
