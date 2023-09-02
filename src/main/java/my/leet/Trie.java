package my.leet;

import java.util.HashMap;

/** 208.前缀树
 *  前缀树: 一种用于存储字符串的数据结构，特点是复用相同的字符串前缀
 */
public class Trie {

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public Trie(String str) {
        root = new TrieNode();
        root.setPass();
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            node.addNext(c);
            node = node.next(c);
        }
        node.setEnd();
    }

    public void insert(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            TrieNode next = node.next(c);
            if (next==null) {
                node.addNext(c);
                next = node.next(c);
            }
            node.setPass();
            node = next;
        }
        node.setEnd();
    }

    public boolean search(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            TrieNode next = node.next(c);
            if (next==null) {
                return false;
            }
            node = next;
        }
        return node.isEnd();
    }

    public boolean startsWith(String str) {
        TrieNode node = root;
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            TrieNode next = node.next(c);
            if (next==null) {
                return false;
            }
            node = next;
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}

class TrieNode {

    private Character c;

    private int pass;

    private int end;

    private HashMap<Character, TrieNode> next;

    public TrieNode() {
        this.c = null;
        this.pass = 0;
        this.end = 0;
        this.next = new HashMap<>();
    }

    public TrieNode(Character c) {
        this.c = c;
        this.pass = 1;
        this.end = 0;
        this.next = new HashMap<>();
    }

    public Character getC() {
        return c;
    }

    public void addNext(Character c) {
        next.put(c, new TrieNode(c));
    }

    public HashMap<Character, TrieNode> getNext() {
        return next;
    }

    public TrieNode next(Character c) {
        return this.next.get(c);
    }

    public int getPass() {
        return pass;
    }

    public boolean isEnd() {
        return end==1;
    }

    public void setPass() {
        this.pass += 1;
    }

    public void setEnd() {
        this.end = 1;
    }
}
