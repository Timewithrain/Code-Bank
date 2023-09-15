package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 17. 电话号码的字母组合 */
public class LetterCombinationsOfAPhoneNumber {

    /** 广度优先  开销：5ms，40.4M */
    static List<String> func(String digits) {
        List<String> list = new ArrayList<>();
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i=0; i<digits.length(); i++) {
            char c = digits.charAt(i);
            String s = map[c - '0'];
            if (i==0) {
                for (int j = 0; j < s.length(); j++) {
                    list.add(s.charAt(j)+"");
                }
            } else {
                List<String> newList = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < s.length(); k++) {
                        newList.add(list.get(j) + s.charAt(k));
                    }
                }
                list = newList;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            ans.add(list.get(i));
        }
        return ans;
    }

    /** 深度优先  开销：0ms，39.9M */
    static void dfs(String digits, String[] map, char[] tmp, int i, List<String> ans) {
        if (i==digits.length()) {
            if (i>0)  // digits为""空串时，ans的应当为空表
                ans.add(new String(tmp));
            return;
        }
        char c = digits.charAt(i);
        String s = map[c - '0'];
        for (int j = 0; j < s.length(); j++) {
            tmp[i] = s.charAt(j);
            dfs(digits, map, tmp, i+1, ans);
        }
    }

    static List<String> func2(String digits) {
        List<String> ans = new ArrayList<>();
        String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        char[] tmp = new char[digits.length()];
        dfs(digits, map, tmp, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        String digits = "23"; // ""; //
        List<String> ans = func2(digits);
        System.out.println(ans);
    }
}
