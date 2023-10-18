package my.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/** 34. 串联所有单词的字串 */
public class SubstringWithConcatenationOffAllWords {

    /** 滑动窗口实现 */
    static List<Integer> func(String s, String[] words) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        int n = words[0].length();
        int len = words.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < i+len*n && j+n <= s.length(); j+=n) {
                String word = s.substring(j, j+n);
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (int j = 0; j < words.length; j++) {
                map.put(words[j], map.getOrDefault(words[j], 0) - 1);
                if (map.get(words[j]) == 0) map.remove(words[j]);
            }
            for (int j = i; j+len*n <= s.length(); j+=n) {
                if (j!=i) {
                    String rmWord = s.substring(j-n, j);
                    map.put(rmWord, map.getOrDefault(rmWord, 0) - 1);
                    if (map.get(rmWord) == 0) map.remove(rmWord);
                    String nwWord = s.substring(j+(len-1)*n, j+len*n);
                    map.put(nwWord, map.getOrDefault(nwWord, 0) + 1);
                    if (map.get(nwWord) == 0) map.remove(nwWord);
                }
                if (map.isEmpty()) {
                    list.add(j);
                }
            }
            map.clear();
        }
        return list;
    }


    public static void main(String[] args) {
        String s = "a"; // "wordgoodgoodgoodbestword"; // "barfoofoobarthefoobarman"; // "wordgoodgoodgoodbestword"; // "barfoothefoobarman"; //
        String[] words = {"a"}; // {"word","good","best","good"}; // {"bar","foo","the"}; // {"word","good","best","word"}; // {"foo", "bar"}; //
        List<Integer> ans = func(s, words);
        System.out.println(ans);
    }
}
