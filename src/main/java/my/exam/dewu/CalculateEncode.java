package my.exam.dewu;

import java.util.Scanner;

/** 计算编码
 * 设定一种将字母编码为8进制数字的方式：a->0,b->1,c->2,d->3,e->4,f->5,g->6,h->7,i->10,j->11
 * 小A将一段字符编码为数字了，但因为故障原始字符串看不到了，仅能看到编码后的结果。给定编码结果，求解有多少种字母组合方式能构成这样的编码。
 * 输入：
 * 111
 * 输出：
 * 3
 * 通过：82%
 */
public class CalculateEncode {

    static long func(String s) {
        int l = s.length();
        if (l==0) return 1;
        long[] dp = new long[l+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= l; i++) {
            if (i>=2 && s.charAt(i-2)=='1') {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[l];
    }

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        in.nextLine();
//        String s = in.nextLine();
        String s = "11111";
        int ans = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='1' || s.charAt(i)=='0') {
                sb.append(s.charAt(i));
            } else {
                ans *= func(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        ans *= func(sb.toString());
        System.out.println(ans%1000000007);
    }
}
