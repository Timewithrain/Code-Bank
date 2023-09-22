package my.leet;

/** 231. 二的幂 */
public class PowerOfTwo {

    static boolean func(int n) {
        if (n<=0) return false;
        return (n & (n-1)) == 0;
    }

    public static void main(String[] args) {
        int n = 0;
        boolean ans = func(n);
        System.out.println(ans);
    }
}
