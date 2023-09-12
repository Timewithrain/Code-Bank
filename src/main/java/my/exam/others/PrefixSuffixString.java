package my.exam.others;

/**
 * 前缀后缀字符串
 * 给定一个字符串s，找到同时作为前缀和后缀最长字符串长度，前缀后缀不重叠
 * 例如：
 * 输入：
 * aabcdaabc
 * 输出：
 * 4
 * 输入:
 * abcabd
 * 输出：
 * 0
 */
public class PrefixSuffixString {

    static int func(String s) {
        int l = s.length();
        int mid = l / 2;
        String a = s.substring(0, mid);
        String b = s.substring(mid, l);
        for (int j = 0; j < b.length(); j++) {
            int i = 0;
            int k = 0;
            for (k = j; k < b.length(); k++) {
                if (i<a.length() && a.charAt(i) == b.charAt(k)) {
                    i++;
                } else {
                    break;
                }
            }
            if (k == b.length()) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        String s = "aabcdaabc"; // "abcabd"; // "abababcccdaaaabcd"; // "abcbca";
        System.out.println(func(s));
    }

}
