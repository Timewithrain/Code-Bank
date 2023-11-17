package my.leet;

/** 97. 交错字符串 */
public class InterLeavingString {

    /** 双指针法出错 */
    static boolean func(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if (l3 != l1 + l2) return false;
        boolean ans = true;
        int a = 0, b = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < l3 && a < l1 && b < l2; i++) {
            if (s1.charAt(a) == s2.charAt(b)) {
                int ta = a, tb = b;
                while (i < s3.length()) {
                    if (s1.charAt(ta) == s2.charAt(tb)) {
                        if (s1.charAt(ta) != s3.charAt(i)) return false;
                        ta++;
                        tb++;
                    } else {
                        if (s1.charAt(ta) == s3.charAt(i)) {
                            for (int j = a; j <= ta; j++) {
                                sb.append(s1.charAt(j));
                            }
                            a = ta+1;
                            break;
                        } else if (s2.charAt(tb) == s3.charAt(i)) {
                            for (int j = b; j <= tb; j++) {
                                sb.append(s2.charAt(j));
                            }
                            b = tb+1;
                            break;
                        }
                    }
                    i++;
                }
            } else {
                if (s1.charAt(a) == s3.charAt(i)) {
                    sb.append(s1.charAt(a));
                    a++;
                } else if (s2.charAt(b) == s3.charAt(i)) {
                    sb.append(s2.charAt(b));
                    b++;
                } else {
                    return false;
                }
            }
        }
        if (a!=l1) sb.append(s1.charAt(a));
        if (b!=l2) sb.append(s2.charAt(b));
        return sb.toString().equals(s3);
    }

    /** 动态规划 */
    static boolean func2(String s1, String s2, String s3) {
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        boolean[][] dp = new boolean[l1+1][l2+1];
        dp[0][0] = true;
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i > 0 && s1.charAt(i-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i-1][j];
                }
                if (j > 0 && s2.charAt(j-1) == s3.charAt(i+j-1)) {
                    dp[i][j] = dp[i][j] || dp[i][j-1];
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String s1 = "aabcc"; // ""; //
        String s2 = "dbbca"; // ""; //
        String s3 = "aadbbcbcac"; // "aadbbbaccc"; // ""; //
        boolean ans = func2(s1, s2, s3);
        System.out.println(ans);
    }
}
