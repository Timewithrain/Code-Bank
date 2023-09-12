package my.exam.others;

/**
 * 一个自重复串是一个字符串，其前一半和后一半是一样的，例如 abcdbabcdb （长度一定是偶数）。输入一个字符串，找出其中最长的自重复子串。
 * 例如：
 * 输入：
 * abababcccdaaaabcd
 * 输出：
 * aaabcdaaabcd
 */
public class RepeatString {

    static String func(String s) {
        int l = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < l; i++) {
            String a = s.substring(0, i+1);
            String b = s.substring(i, l);
            int ai = 0;
            int bi = 0;
            StringBuilder tmp = new StringBuilder();
            while (ai<a.length() && bi<b.length()) {
                if (a.charAt(ai) == b.charAt(bi)) {
                    tmp.append(a.charAt(ai));
                    ai++;
                    bi++;
                } else {
                    if (a.length()>b.length()) ai++;
                    else bi++;
                }
            }
            if (tmp.length()*2 > ans.length()) ans = tmp.append(tmp);
        }
        return ans.toString();
    }


    public static void main(String[] args) {
        String s = "aabcdaabc"; // ""abababcccdaaaabcd"; // "abcbca";
        System.out.println(func(s));
    }
}
