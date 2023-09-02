package my.leet;

/**
 * 541. 反转字符串II
 */
public class ReverseStringII {

    static void reverse(StringBuilder s, int i, int j) {
        char t;
        for (; i<j; i++,j--) {
            t = s.charAt(i);
            s.setCharAt(i, s.charAt(j));
            s.setCharAt(j, t);
        }
    }

    static String func(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int i = 1;
        for (; i*k-1 < sb.length(); i++) {
            if (i%2 == 1) {
                reverse(sb, i*k-k, i*k-1);
            }
        }
        if (i%2==1 && i*k-1>=sb.length()) reverse(sb, i*k-k, sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 8;
        String ans = func(s, k);
        System.out.println(ans);
    }

}
