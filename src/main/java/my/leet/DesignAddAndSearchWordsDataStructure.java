package my.leet;

import java.util.ArrayList;

/** 211. 添加与搜索单词 */
public class DesignAddAndSearchWordsDataStructure {

    static void testTrie() {
        TrieNodeII trie = new TrieNodeII();
        String a = "abcde";
        String b = "abc";
        String c = "123";
        String d = "123456";
        trie.add(a);
        trie.add(b);
        trie.add(c);
        trie.add(d);
        System.out.println(trie.search(a));
        System.out.println(trie.search(c));
        System.out.println(trie.search(d));
        System.out.println(trie.search("123"));
        System.out.println("abcde".substring(1));
    }

    static void testWordDictionary() {
        WordDictionary wd = new WordDictionary();
//        wd.addWord("pad");
//        wd.addWord("mad");
//        System.out.println(wd.search(".ad"));

        wd.addWord("a");
        wd.addWord("a");
        System.out.println(wd.search(".a"));
    }

    public static void main(String[] args){
        testWordDictionary();
    }
}

// 构造前缀树
class TrieNodeII {
    public char c;
    public ArrayList<TrieNodeII> children;
    public boolean endTag;

    public TrieNodeII() {
        this.children = new ArrayList<>();
        this.endTag = false;
    }

    public TrieNodeII(char c) {
        this.c = c;
        this.children = new ArrayList<>();
        this.endTag = false;
    }

    public void add(String word) {
        int l = word.length();
        TrieNodeII node = this;
        for (int i = 0; i < l; i++) {
            TrieNodeII nex = null;
            for (int j = 0; j < node.children.size(); j++) {
                if (word.charAt(i) == node.children.get(j).c) {
                    nex = node.children.get(j);
                    if (i==l-1) nex.endTag = true;
                    break;
                }
            }
            if (i<l && nex == null) {
                nex = new TrieNodeII(word.charAt(i));
                node.children.add(nex);
                if (i==l-1) nex.endTag = true;
            }
            node = nex;
        }
    }

    public boolean search(String word) {
        boolean ans = false;
        int l = word.length();
        if (l==0) return true;
        TrieNodeII node = this;
        for (int i = 0; i < l; i++) {
            TrieNodeII nex = null;
            for (int j = 0; j < node.children.size(); j++) {
                if (word.charAt(i) == node.children.get(j).c) {
                    nex = node.children.get(j);
                    if (i == l-1 && nex.endTag) return true;
                    break;
                }
            }
            if (nex == null) return ans;
            node = nex;
        }
        return ans;
    }
}

// 参考前缀树构造字典
class WordDictionary {

    DicNode root = null;

    static class DicNode {
        public char c;
        public ArrayList<DicNode> children;
        public boolean endTag;

        public DicNode() {
            this.children = new ArrayList<>();
            this.endTag = false;
        }

        public DicNode(char c) {
            this.c = c;
            this.children = new ArrayList<>();
            this.endTag = false;
        }
    }

    public WordDictionary() {
        this.root = new DicNode();
    }

    public void addWord(String word) {
        int l = word.length();
        DicNode node = root;
        for (int i = 0; i < l; i++) {
            DicNode nex = null;
            for (int j = 0; j < node.children.size(); j++) {
                if (word.charAt(i) == node.children.get(j).c) {
                    nex = node.children.get(j);
                    if (i==l-1) nex.endTag = true;
                    break;
                }
            }
            if (nex == null) {
                nex = new DicNode(word.charAt(i));
                node.children.add(nex);
                if (i==l-1) nex.endTag = true;
            }
            node = nex;
        }
    }

    public boolean searchWord(DicNode root, String word) {
        boolean ans = false;
        int l = word.length();
        if (l==0) return false;
        DicNode node = root;
        for (int i = 0; i < l; i++) {
            DicNode nex = null;
            if (word.charAt(i) != '.') {
                for (int j = 0; j < node.children.size(); j++) {
                    if (word.charAt(i) == node.children.get(j).c) {
                        nex = node.children.get(j);
                        if (i == l-1 && nex.endTag) return true;
                        break;
                    }
                }
            } else {
                for (int j = 0; j < node.children.size(); j++) {
                    if (i==l-1 && node.children.get(j).endTag) return true;
                    ans = ans || searchWord(node.children.get(j), word.substring(i+1));
                    if (ans) return ans;
                }
            }
            if (nex == null) return ans;
            node = nex;
        }
        return ans;
    }

    public boolean search(String word) {
        return searchWord(root, word);
    }

}