package my.leet;

import java.util.ArrayList;
import java.util.HashMap;


/** 115. 不同的子序列 (官方测试用例有问题) */
public class DistinctSubsequence {

    /** 深搜超时 */
    static int dfs(String s, String t, int i, int j, int ans) {
        if (j==t.length()) return ans + 1;
        if (i==s.length()) return ans;
        for (int k = i; k < s.length(); k++) {
            if (s.charAt(k) == t.charAt(j)) {
                ans = Math.max(ans, dfs(s, t, k+1, j+1, ans));
            }
        }
        return ans;
    }

    static int func(String s, String t) {
        int ans = dfs(s, t, 0, 0, 0);
        return ans;
    }

    /** 深搜优化，超时 */
    static int dfs2(String s, String t, int i, int j, HashMap<Character, ArrayList<Integer>> map, int ans) {
        if (j==t.length()) return ans + 1;
        if (i==s.length()) return ans;
        ArrayList<Integer> list = map.get(t.charAt(j));
        if (list==null) return ans;
        for (int k = 0; k < list.size(); k++) {
            int nex = list.get(k);
            if (i <= nex) {
                ans = Math.max(ans, dfs2(s, t, nex+1, j+1, map, ans));
            }
        }
        return ans;
    }

    static int func2(String s, String t) {
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.get(s.charAt(i)).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(s.charAt(i), list);
            }
        }
        int ans = dfs2(s, t, 0, 0, map, 0);
        return ans;
    }

    /** 动态规划 */
    static int func3(String s, String t) {
        int sl = s.length();
        int tl = t.length();
        if (sl < tl) return 0;
        int[][] dp = new int[sl][tl];
        // 初始化dp
        dp[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for (int i = 1; i < sl; i++) {
            if (s.charAt(i) == t.charAt(0)) {
                dp[i][0] = 1;
            }
            dp[i][0] += dp[i-1][0];
        }

        for (int i = 1; i < sl; i++) {
            for (int j = 1; j <= i && j < tl; j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[sl-1][tl-1];
    }

    public static void main(String[] args) {
        String s = "rabbbit";  //"a"; // "babgbag";  // "rabbbit"; // "rabbbit"; // "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc"; //
        String t = "rabit";  //"b"; //""bag"; // "rabit"; // "rabbit"; // "bcddceeeebecbc"; //
        System.out.println(func3(s, t));
    }
}
