package my.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 212. 单词搜索II */
public class WordSearchII {

    /** 暴力深搜，超时 */
    static boolean dfs(char[][] board, int i, int j, int pos, int[][] visited, String s) {
        if (pos == s.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] == 1) return false;
        visited[i][j] = 1;
        boolean ans = false;
        if (board[i][j] == s.charAt(pos)) {
            ans = ans || dfs(board, i+1, j, pos+1, visited, s);
            ans = ans || dfs(board, i, j+1, pos+1, visited, s);
            ans = ans || dfs(board, i-1, j, pos+1, visited, s);
            ans = ans || dfs(board, i, j-1, pos+1, visited, s);
        }
        visited[i][j] = 0;
        return ans;
    }

    static List<String> func(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int[][] visited = new int[board.length][board[0].length];
        for (int n = 0; n < words.length; n++) {
            String s = words[n];
            boolean in = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (dfs(board, i, j, 0, visited, s)) {
                        in = true;
                        break;
                    }
                }
                if (in) break;
            }
            if (in) ans.add(s);
        }
        return ans;
    }

    /** 前缀树+深搜，使用前缀树存储全部words，深搜过程中匹配前缀树 */
    static void dfs(char[][] board, int i, int j, int[][] visited, MyTrie trie, List<String> ans) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] == 1) return ;
        if (!trie.children.containsKey(board[i][j])) return;
        trie = trie.children.get(board[i][j]);
        visited[i][j] = 1;
        if (!trie.word.equals("") && !ans.contains(trie.word)) ans.add(trie.word);  // 前缀树当前节点word不为空则查到结果
        dfs(board, i+1, j, visited, trie, ans);
        dfs(board, i, j+1, visited, trie, ans);
        dfs(board, i-1, j, visited, trie, ans);
        dfs(board, i, j-1, visited, trie, ans);
        visited[i][j] = 0;
    }

    static List<String> func2(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int[][] visited = new int[board.length][board[0].length];
        MyTrie trie = new MyTrie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, visited, trie, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'}}; // {{'a','b','c'},{'a','e','d'},{'a','f','g'}}; //
        String[] words = {"a"}; // {"dgc", "abcdefg"};
//        List<String> ans = func(board, words);
        List<String> ans = func2(board, words);
        System.out.println(ans);
    }
}

class MyTrie {
    String word;
    Map<Character, MyTrie> children;
    boolean isWord;

    public MyTrie() {
        this.word = "";  // 默认为空串，当有字符串以当前trie节点结尾时，word为该字符串
        this.children = new HashMap<Character, MyTrie>();
    }

    public void insert(String word) {
        MyTrie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char c = word.charAt(i);
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new MyTrie());
            }
            cur = cur.children.get(c);
        }
        cur.word = word;
    }
}
