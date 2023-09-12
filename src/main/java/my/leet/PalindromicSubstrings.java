package my.leet;

/** 647. 回文子串 */
public class PalindromicSubstrings {

    static boolean isPalindromic(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    static int func(String s) {
        int l = s.length();
        int[] dp = new int[l];
        dp[0] = 1;
        for (int i = 1; i < l; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = i-1; j >= 0; j--) {
                if (isPalindromic(s, j, i)) {
                    dp[i]++;
                }
            }
        }
        return dp[l-1];
    }

    public static void main(String[] args) {
        String s = "aaa"; // ""abc";
        System.out.println(func(s));
    }
}
