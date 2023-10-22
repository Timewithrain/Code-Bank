package my.leet;

import java.util.HashMap;

/** 290. 单词规律 */
public class WordPattern {

    static boolean func(String pattern, String s) {
        boolean ans = true;
        String[] words = s.split(" ");
        int l = pattern.length();
        if (l != words.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            String tmp;
            if (!map.containsKey(c) && !map.containsValue(w)) {
                map.put(c, w);
            } else {
                if (!((tmp=map.get(c)) != null && tmp.equals(w))) {
                    return false;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "dog cat cat dog";
        String pattern = "abba";
        boolean ans = func(pattern, s);
        System.out.println(ans);
    }
}
