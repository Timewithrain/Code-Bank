package my.exam.others;

/**
 * 小红拿到一个字符串s，她想知道有多少个长度不超过k且仅包含小写字母的字符串满足字典序小于s？
 * 由于答案过大，输出对1000000007取模
 */
public class HongString {

    static long func(String s, int k) {
        int sl = s.length();
        long ans1 = 0;
        long ans2 = 0;
        for (int i = 0; i < sl && i < k; i++) {
            int cur = 0;
            for (int j = 'a'; j <= 'z'; j++) {
                if (s.charAt(i) > j) {
                    cur += Math.pow(26, (k-i-1));
                }
                if (s.charAt(i) == j) {
                    if (i < sl-1 && i < k-1) {
                        ans2 = ans2!=0 ? ans2 * s.charAt(i) - 'a' + 1 : s.charAt(i) - 'a' + 1 ;
                    }
                }
            }
            ans1 += cur;
        }
        return (ans1 + ans2) % 1000000007;
    }

    public static void main(String[] args){
        String s = "c";
        int k = 2;
        long ans = func(s, k);
        System.out.println(ans);
    }
}
