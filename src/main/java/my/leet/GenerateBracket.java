package my.leet;

import java.util.*;

/**
 * 22. 生成括号
 */
public class GenerateBracket {

    static boolean valid(char[] s) {
        int left = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') {
                left += 1;
            } else {
                left -= 1;
            }
            if (left < 0) return false;
        }
        return left == 0;
    }

    static void f(int n, int pos, int left, char[] s, Set<String> set) {
        if (pos == s.length) {
            if (valid(s)) {
                set.add(String.copyValueOf(s));
            }
            return;
        }
        if (left <= n) {
            s[pos] = '(';
            left += 1;
            f(n, pos+1, left, s, set);
            left -= 1;
        }
        if (pos-left <= n) {
            s[pos] = ')';
            f(n, pos+1, left, s, set);
        }
    }

    static List<String> func(int n) {
        Set<String> set = new HashSet<>();
        char[] s = new char[2*n];
        f(n, 0, 0, s, set);
        return new ArrayList<String>(set);
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = func(n);
        System.out.println(ans);
    }

}
