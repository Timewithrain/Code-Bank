package my.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/** 49. 字母异位词分组 */
public class GroupAnagrams {

    static String encode(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new StringBuilder().append(chars).toString();
    }

    static List<List<String>> func(String[] strs) {
        List<List<String>> ans = null;
        HashMap<String, List<String>> map = new HashMap<>();
        int l = strs.length;
        for (int i = 0; i < l; i++) {
            String ed = encode(strs[i]);
            if (map.containsKey(ed)) {
                map.get(ed).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(ed, list);
            }
        }
        for (List<String> list : map.values()) {
            if (ans == null) {
                ans = new ArrayList<>();
            }
            ans.add(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ans = func(strs);
        System.out.println(ans);
    }
}
