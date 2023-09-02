package my.leet;

import java.util.HashSet;

/**
 * 202. 快乐数
 */
public class HappyNumber {

    public static int trans(int n) {
        int ans = 0;
        while (n>0) {
            ans += (n%10) * (n%10);
            n /= 10;
        }
        return ans;
    }

    public static boolean func(int n) {
        HashSet<Integer> set = new HashSet<>();  // 用于判断是否循环
        set.add(n);
        while (n!=1) {
            n = trans(n);
            if (set.contains(n)) return false;
            set.add(n);
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 191;
        System.out.println(func(n));
    }
}
