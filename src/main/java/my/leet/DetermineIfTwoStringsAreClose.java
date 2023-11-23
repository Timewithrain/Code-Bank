package my.leet;

import java.util.HashMap;
import java.util.Map;

/** 1675. 确定两个字符串是否接近 */
public class DetermineIfTwoStringsAreClose {

    static boolean sameChar(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        boolean ans = true;
        int[] a1 = new int[26];
        int[] a2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            a1[word1.charAt(i) - 'a'] += 1;
            a2[word2.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {  // 若出现不同的字符直接返回false
            if ((a1[i]==0 && a2[i]!=0) || (a1[i]!=0 && a2[i]==0)) return false;
        }
        for (int i = 0; i < 26; i++) {
            if (a1[i] != 0 && a2[i] != 0 && a1[i] != a2[i]) {  // 若出现的字符集相同，但出现的个数不同，则进一步判断个数是否支持互换
                ans = false;
                break;
            }
        }
        if (ans) return ans;
        ans = true;
        HashMap<Integer, Integer> m1 = new HashMap<>();  // 使用map校验字符出现的个数是否匹配
        HashMap<Integer, Integer> m2 = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            m1.put(a1[i], m1.getOrDefault(a1[i], 0) + 1);
            m2.put(a2[i], m2.getOrDefault(a2[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
            if (m2.get(entry.getKey()) == null || !entry.getValue().equals(m2.get(entry.getKey()))) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    static boolean func(String word1, String word2) {
        return sameChar(word1, word2);
    }

    public static void main(String[] args) {
        String word1 = "zwmqwwwcqwwqcqqcqqccqqcmqccqqqqccqqqwqqqqqcqwqm"; // "aabbcccddd"; //
        String word2 = "xhchhcxhhhhrcxhhxxchcxhhchrhhcxhcxhxrhhhhhhxhex"; // "abccccdddd"; //
        boolean ans = func(word1, word2);
        System.out.println(ans);
    }
}
