package my.leet;

/** 5. 最长回文子串 */
public class LongestPalindromicSubstring {

    static String func(String s) {
        int l = s.length();
        int start = 0, end = 0;
        for (int i = 0; i < l; i++) {
            int st = i-1, ed = i+1;
            while (st>=0 && ed<l) {  // 判断长度为奇数，以i为中心两端对称的回文串
                if (s.charAt(st) != s.charAt(ed)) break;
                if (ed - st > end - start) {
                    start = st;
                    end = ed;
                }
                st--;
                ed++;
            }
            st = i;
            ed = i+1;
            while (st>=0 && ed<l) {  // 判断长度为偶数，以i和i+1为中心两端对称的回文串
                if (s.charAt(st) != s.charAt(ed)) break;
                if (ed - st > end - start) {
                    start = st;
                    end = ed;
                }
                st--;
                ed++;
            }
        }
        return s.substring(start, end+1);
    }

    public static void main(String[] args){
        String s = "a";  // "cbbd";  // "babad";
        String ans = func(s);
        System.out.println(ans);
    }
}
