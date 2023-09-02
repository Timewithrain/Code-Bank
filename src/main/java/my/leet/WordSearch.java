package my.leet;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class WordSearch {

    static boolean dfs(char[][] board, int[][] fill, int i, int j, String str, int k, List<String> ans, boolean ret) {
        if (ret) return ret;
        if (i<0 || i>=board.length || j<0 || j>=board[i].length) return ret;
        if (fill[i][j]==1) return ret;
        fill[i][j] = 1;
        if (k==str.length()-1) {
            if (str.charAt(k)==board[i][j]) {
                ans.add(str);
                ret = true;
            }
            fill[i][j] = 0;
            return ret;
        }
        if (str.charAt(k) != board[i][j]) {
            fill[i][j] = 0;
            return ret;
        }
        ret = dfs(board, fill, i+1, j, str, k+1, ans, ret);
        ret = dfs(board, fill, i-1, j, str, k+1, ans, ret);
        ret = dfs(board, fill, i, j+1, str, k+1, ans, ret);
        ret = dfs(board, fill, i, j-1, str, k+1, ans, ret);
        fill[i][j] = 0;
        return ret;
    }

    static List<String> func(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        int[][] fill = new int[board.length][board[0].length];
        for (int k = 0; k < words.length; k++) {
            boolean ret = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    ret = dfs(board, fill, i, j, words[k], 0, ans, ret);
                    if (ret) break;
                }
                if (ret) break;
            }
        }
        ans.sort(Comparator.naturalOrder());
        return ans;
    }

    public static void main(String[] args) {
//        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
//        String[] words = {"eat", "oath"};
        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        String[] words = {"oa","oaa"};
        List<String> ans = func(board, words);
        System.out.println(ans);
    }

}
