package my.leet;

import java.util.HashMap;

/** 205. 同构字符串 */
public class IsomorphicString {

    static boolean func(String s, String t) {
        boolean ans = true;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char si = s.charAt(i);
            char ti = t.charAt(i);
            if (map.containsKey(si)) {
                if (map.get(si) != ti) return false;
            } else {
                if (map.containsValue(ti)) return false;
                map.put(si, ti);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "egg"; // "fol"; // "paper"; // "badc"; //
        String t = "add"; // "bar"; // "title"; // "baba"; //
        boolean ans = func(s, t);
        System.out.println(ans);
    }
}
