package my.leet;

/** 345. 反转元音字母 */
public class ReverseVowelsOfAString {

    static String func(String s) {
        StringBuilder sb = new StringBuilder(s);
        char[] sub = new char[s.length()];
        int[] ref = new int[s.length()];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='a' || c=='e' || c=='i' || c=='o' || c=='u' ||
                c=='A' || c=='E' || c=='I' || c=='O' || c=='U') {
                sub[idx] = c;
                ref[idx++] = i;
            }
        }
        int len = idx - 1;
        while (--idx > 0) {
            sb.setCharAt(idx, sub[idx]);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        
    }
}
