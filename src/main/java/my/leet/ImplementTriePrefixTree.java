package my.leet;

import java.util.HashMap;

/** 208. 实现前缀树(Trie) */
public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        TrieII trie = new TrieII();
        boolean ans = false;
//        trie.insert("apple");
//        ans = trie.search("apple");
//        System.out.println(ans);
//        ans = trie.search("app");
//        System.out.println(ans);
//        ans = trie.startsWith("app");
//        System.out.println(ans);
//        trie.insert("app");
//        ans = trie.search("app");
//        System.out.println(ans);
        trie.insert("hello");
        ans = trie.search("helloa");
        System.out.println(ans);
    }
}

class TrieII {

    class TrieNode {
        Character c;
        HashMap<Character, TrieNode> next;
        boolean end;

        public TrieNode (Character c) {
            this.c = c;
            this.next = new HashMap<>();
            this.end = false;
        }
    }

    private HashMap<Character, TrieNode> root;

    public TrieII() {
        root = new HashMap<>();
    }

    public void insert(String word) {
        HashMap<Character, TrieNode> nex = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (nex.containsKey(c)) {
                TrieNode node = nex.get(c);
                if (i==word.length()-1) node.end = true;
                nex = node.next;
            } else {
                TrieNode node = new TrieNode(c);
                if (i==word.length()-1) node.end = true;
                nex.put(c, node);
                nex = nex.get(c).next;
            }
        }
    }

    public boolean search(String word) {
        boolean ans = false;
        HashMap<Character, TrieNode> nex = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (nex.containsKey(c)) {
                TrieNode cur = nex.get(c);
                if (i==word.length()-1) ans = cur.end;
                nex = cur.next;
            } else {
                break;
            }
        }
        return ans;
    }

    public boolean startsWith(String prefix) {
        HashMap<Character, TrieNode> nex = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (nex.containsKey(c)) {
                nex = nex.get(c).next;
            } else {
                return false;
            }
        }
        return true;
    }
}
