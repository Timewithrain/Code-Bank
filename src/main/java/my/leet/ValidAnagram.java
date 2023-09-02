package my.leet;

import java.util.HashMap;

/**
 * 242. 有效的字母异位词
 */
public class ValidAnagram {

    static boolean func(String s, String t) {
        if (s.length()!=t.length()) return false;
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i)))
                sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
            else
                sMap.put(s.charAt(i), 1);
            if (tMap.containsKey(t.charAt(i)))
                tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
            else
                tMap.put(t.charAt(i), 1);
        }
        if (sMap.keySet().size()!=tMap.keySet().size()) return false;
        for (Character c : sMap.keySet()) {
            if (!tMap.containsKey(c)) return false;
            if (!sMap.get(c).equals(tMap.get(c))) return false;  // Integer包裹类型比较必须用equals()
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";  // "anagram";
        String t = "car";  // "nagaram";
        System.out.println(func(s, t));
    }
}
