package my.leet;

import java.util.HashMap;
import java.util.Map;

/** 76. 最小覆盖子串 */
public class MinimumWindowSubstring {

    static boolean match(HashMap<Character, Integer> map) {
        boolean ans = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    /** 出错，部分通过 */
    static String func(String s, String t) {
        StringBuilder ans = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        boolean flag = false;
        int i = -1, j = 0, l = s.length();
        int[] idx = new int[]{-1, 0};
        while (i <= j && j < l) {
            while (j < l && !match(map)) {
                Character c = s.charAt(j);
                if (map.containsKey(c))
                    map.put(c, map.get(c)-1);
                if (!flag) idx[1] = j;
                j++;
            }
            if (match(map)) {
                if (idx[1] - i < idx[1] - idx[0]) idx[1] = j - 1;
                flag = true;
            }
            while (i < j && match(map)) {
                if (idx[1] - i < idx[1] - idx[0]) {
                    idx[0] = i;
                    flag = true;
                }
                Character c = s.charAt(++i);
                if (map.containsKey(c))
                    map.put(c, map.get(c)+1);
            }
        }
        for (i = idx[0]+1; flag && i <= idx[1] && i < l; i++) {
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "a"; // "abc"; // "ab"; // "ADOBECODEBANC"; // "aa"; // "a"; //
        String t = "aa"; // "b"; // "a"; // "ABC"; // "b"; // "aa"; //
        String ans = func(s, t);
        System.out.println(ans);
    }
}
