package my.leet;

/** 9. 回文数 */
public class PalindromesNumber {

    static boolean func(int x) {
        boolean ans = true;
        String s = String.valueOf(x);
        int l = s.length();
        for (int i = 0; i < l/2; i++) {
            if (s.charAt(i) != s.charAt(l-1-i)) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    /** 不使用字符串实现 */
    static boolean func2(int x) {
        if (x<0) return false;
        int reverse = 0;
        int t = x;
        while (x > 0) {
            reverse *= 10;
            reverse += x % 10;
            x = x / 10;
        }
        return reverse == t;
    }

    public static void main(String[] args) {
        int x = 10; // 121; //
        boolean ans = func2(x);
        System.out.println(ans);
    }
}
