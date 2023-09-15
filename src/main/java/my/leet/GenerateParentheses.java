package my.leet;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GenerateParentheses {

    /** 栈判断括号是否合理 */
    static boolean isValid(char[] tmp, int i) {
        LinkedList<Character> stack = new LinkedList<>();
        for (int j = 0; j <= i; j++) {
            if (tmp[j] == '(') {
                stack.push(tmp[j]);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c = stack.pop();
                if (c!='(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /** 单边计数判断 */
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

    static void dfs(char[] tmp, int i, List<String> ans) {
        if (i==tmp.length) {
            if (isValid(tmp, i-1)) {
                ans.add(new String(tmp));
            }
            return;
        }
        tmp[i] = '(';
        dfs(tmp, i+1, ans);
        tmp[i] = ')';
        dfs(tmp, i+1, ans);
    }

    static List<String> func(int n) {
        List<String> ans = new ArrayList<>();
        char[] tmp = new char[2*n];
        dfs(tmp, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = func(n);
        System.out.println(ans);
//        String s = "()()";
//        System.out.println(isValid(s.toCharArray(), s.length()-1));
    }
}
