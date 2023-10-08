package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.HashMap;
import java.util.HashSet;
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

    /** 滑动窗口标准实现，双指针指向滑动窗口的上下边界，使用HashSet存储滑动窗口内的元素， */
    static int func3(String s) {
        int ans = 0;
        int l = s.length();
        if (l==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0, right = 0;  // 初始化滑动窗口上下界
        for (; left < l; left++) {  // 计算以每个字符作为下界的最长字串，使用滑动窗口统计字串长度
            while (right < l && !set.contains(s.charAt(right))) {  // 若元素不重复，right右移，窗口范围增加
                set.add(s.charAt(right));
                right++;
            }
            ans = Math.max(ans, right-left);
            set.remove(s.charAt(left));  // 删除当前下界，下一次循环统计，从下一个字符开始的最长字串
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "bbbbb";  // " ";  // "pwwkew";  // "abcdabcceabcd";  //
        int ans = func3(s);
        System.out.println(ans);
    }
}
