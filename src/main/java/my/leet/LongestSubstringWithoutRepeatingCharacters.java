package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/** 3. 无重复字符的最长子串 */
public class LongestSubstringWithoutRepeatingCharacters {

    /** O(n^2) */
    static int func(String s) {
        int ans = 0;
        int l = s.length();
        if (l==0) return ans;
        int[] dp = new int[l];
        dp[0] = 1;
        ans = 1;
        for (int i = 1; i < l; i++) {
            char c = s.charAt(i);
            int cnt = 1;
            boolean flag = true;
            for (int j = i-1; j >= 0 && j >= i-dp[i-1]; j--) {  // 每次向前查找，直到dp[i-1]长度之前
                if (s.charAt(j) == c) {
                    flag = false;
                    break;
                }
                cnt++;
            }
            if (flag) {
                dp[i] = dp[i-1] + 1;
            } else {
                dp[i] = cnt;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    /** 滑动窗口实现，使用HashMap定义滑动窗口，当遇见重复值时，仅保留重复值两次出现之间的字符，其他都删除，统计map的最大长度 */
    static int func2(String s) {
        int l = s.length();
        if (l==0) return 0;
        int ans = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                int start = map.get(c);
                Iterator itr = map.entrySet().iterator();
                while (itr.hasNext()) {
                    Map.Entry<Character, Integer> entry = (Map.Entry) itr.next();
                    if (entry.getValue() < start) {
                        itr.remove();
                    }
                }
            }
            map.put(c, i);
            ans = Math.max(ans, map.size());
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "abcdabcceabcd";  // "pwwkew";  // " ";  // "bbbbb";  //
        int ans = func2(s);
        System.out.println(ans);
    }
}
