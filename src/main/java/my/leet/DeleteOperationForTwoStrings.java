package my.leet;

/** 583. 两个字符串的删除操作 */
public class DeleteOperationForTwoStrings {

    static int func(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 1; i <= l1; i++) dp[i][0] = i;
        for (int i = 1; i <= l2; i++) dp[0][i] = i;
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j<= l2; j++) {
                if (word1.charAt(i-1)!=word2.charAt(j-1)) {
                    // 失配情况下，维持字串相等，将多出的字符删去
                    dp[i][j] = Math.min(dp[i-1][j-1] + 2, Math.min(dp[i-1][j], dp[i][j-1]) + 1);
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]) + 1);
                }
            }
        }
        return dp[l1][l2];
    }

    static int func2(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return l1+l2 - 2*dp[l1][l2];
    }

    public static void main(String[] args) {
        String word1 = "lettcode"; // "sea"; // "a"; // "kitten"; //  "eat"; //"park"; //
        String word2 = "etco"; // "eat"; // "ab"; // "sitting"; // ""sea"; // "spake";  //
        System.out.println(func(word1, word2));
        System.out.println(func2(word1, word2));
    }
}
