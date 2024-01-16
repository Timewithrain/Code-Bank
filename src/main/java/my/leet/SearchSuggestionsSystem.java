package my.leet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/** 1268. 搜索推荐系统 */
public class SearchSuggestionsSystem {

    static class TrieNode {
        public Character c;
        public TreeMap<Character, TrieNode> next;
        public boolean end;

        public TrieNode() {
            next = new TreeMap<>();
            end = false;
        }

        public TrieNode(char c) {
            this.c = c;
            this.next = new TreeMap<>();
            this.end = false;
        }

        public void add(String s) {
            int l = s.length();
            TrieNode node = this;
            for (int i = 0; i < l; i++) {
                Character c = s.charAt(i);
                if (node.next.containsKey(c)) {
                    node = node.next.get(c);
                    if (i == l-1) node.end = true;
                } else {
                    TrieNode n = new TrieNode(c);
                    if (i == l-1) n.end = true;
                    node.next.put(c, n);
                    node = n;
                }
            }
        }

        public boolean search(String s) {
            int l = s.length();
            boolean flag = false;
            TrieNode node = this;
            for (int i = 0; i < l; i++) {
                if (node.next.containsKey(s.charAt(i))) {
                    node = node.next.get(s.charAt(i));
                } else {
                    break;
                }
            }
            if (node.end) flag = true;
            return flag;
        }

        static List<String> dfs(TrieNode node, StringBuilder sb, int k, List<String> ans) {
            sb.append(node.c);
            if (node.end) ans.add(sb.toString());
            Iterator<Character> itr = node.next.keySet().iterator();
            while (ans.size() != k && itr.hasNext()) {
                Character c = itr.next();
                dfs(node.next.get(c), sb, k, ans);
            }
            sb.deleteCharAt(sb.length()-1);
            return ans;
        }

        public List<String> get(String s, int k) {
            int l = s.length();
            StringBuilder sb = new StringBuilder();
            List<String> ans = new ArrayList<>();
            TrieNode node = this;
            for (int i = 0; i < l; i++) {
                Character c = s.charAt(i);
                if (node.next.containsKey(c)) {
                    node = node.next.get(c);
                } else {
                    return ans;
                }
            }
            sb.append(s.substring(0, l-1));
            ans = dfs(node, sb, k, ans);
            return ans;
        }
    }

    static List<List<String>> func(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        int l = products.length;
        TrieNode tire = new TrieNode();
        for (int i = 0; i < l; i++) {
            tire.add(products[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            sb.append(searchWord.charAt(i));
            ans.add(tire.get(sb.toString(), 3));
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
