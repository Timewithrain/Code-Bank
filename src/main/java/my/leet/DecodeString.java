package my.leet;

import java.util.LinkedList;

/**
 * 394. 字符串解码
 */
public class DecodeString {

    /** 出错 */
    static String func(String s) {
        StringBuilder sb = new StringBuilder();
        String[] sp = s.split("]");
        int l = sp.length;
        for (int i = 0; i < l; i++) {
            String t = sp[i];
            int start = 0;
            int divide = 0;
            for (int j = 0; j < t.length(); j++) {
                if (Character.isLetter(t.charAt(j))) {
                    sb.append(t.charAt(j));
                    start = j + 1;
                }
                if (t.charAt(j) == '[') {
                    divide = j;
                    break;
                }
            }
            if (start >= divide) continue;
            int n = Integer.parseInt(t.substring(start, divide));
            String ss = t.substring(divide+1);
            for (int j = 0; j < n; j++) {
                sb.append(ss);
            }
        }
        return sb.toString();
    }

    static String retrieve(String s) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> digits = new LinkedList<>();
        LinkedList<StringBuilder> chars = new LinkedList<>();
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                n = n * 10;
                n += c - '0';
            }
            if (Character.isLetter(c)) sb.append(c);
            if (c == '[') {
                digits.push(n);
                n = 0;
                chars.push(sb);
                sb = new StringBuilder();
            }
            if (c == ']') {
                int cnt = digits.pop();
                StringBuilder pre = chars.pop();
                for (int j = 0; j < cnt; j++) {
                    pre.append(sb);
                }
                sb = pre;
            }
        }
        if (chars.size() == 0) return sb.toString();
        StringBuilder ans = chars.pop();
        ans.append(sb);
        return ans.toString();
    }

    static String func2(String s) {
        return retrieve(s);
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]"; // "3[z]2[2[y]pq4[2[jk]e1[f]]]ef"; //
        String ans = func2(s);
        System.out.println(ans);
    }
}
