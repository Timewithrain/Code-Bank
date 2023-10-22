package my.leet;

import java.util.*;

/** 139. 单词拆分 */
public class WordBreak {

    /** dfs 超时 */
    static boolean dfs(String s, int start, int end, HashSet<String> set) {
        if (start == end) return true;
        boolean ans = false;
        for (int i = start+1; i <= end; i++) {
            if (set.contains(s.substring(start, i))) {
                ans = dfs(s, i, end, set);
                if (ans) return ans;
            }
        }
        return ans;
    }

    static boolean func(String s, List<String> wordDict) {
        boolean ans = true;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
        }
        ans = dfs(s, 0, s.length(), set);
        return ans;
    }

    /** 动态规划法 时间复杂度: O(n^2)*/
    static boolean func2(String s, List<String> wordDict) {
        int l = s.length();
        HashSet<String> set = new HashSet<>();
        set.addAll(wordDict);
        boolean[] ans = new boolean[l+1];  // 使用boolean[i]记录前i个是否可以由wordDict组成
        ans[0] = true;
        for (int i = 1; i <= l; i++) {
            for (int j = 0; j < i; j++) {
                if (ans[j] && set.contains(s.substring(j, i))) {
                    ans[i] = true;
                    break;
                }
            }
        }
        return ans[l];
    }

    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"; /// "catsandog"; // "leetcode"; // "applepenapple"; // "applepenapple"; //
        String[] dic = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"}; // {"cats","dog","sand","and","cat"}; // {"leet", "code"}; // {"cats", "dog", "sand", "and", "cat"}; // {"apple", "pen"}; //
        ArrayList<String> wordDict = new ArrayList<>(Arrays.asList(dic));
        boolean ans = func2(s, wordDict);
        System.out.println(ans);
    }
}
