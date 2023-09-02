package my.leet;

/**
 * 392. 判断子序列
 */
public class JudgeSubsequence {

    public static boolean func(String s, String t) {
        if (s.length()==0 && t.length()==0) return true;
        boolean ans = false;
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j<s.length() && t.charAt(i)==s.charAt(j)) j += 1;
            if (j==s.length()) {
                ans = true;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "abec";
        String t = "ahbgdc";
        System.out.println(func(s, t));
    }
}
