package my.leet;

/**
 * 231. 2的幂
 */
public class TwoPower {

    /** 标准解法，不使用循环判断。2的幂必然大于0，且与其自身-1按位与结果必为0 */
    static boolean func(int n) {
        return n>0 && (n & (n-1)) == 0;
    }

    /** 循环判断，累计1的个数，若1的个数超过1个，则必不为2的幂 */
    static boolean func1(int n ) {
        int one = 0;
        if (n<=0) return false;
        while (n!=0) {
            one += n & 1;
            if (one > 1) return false;
            n = n>>>1;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 2;
        boolean ans = func(n);
        System.out.println(ans);
    }
}
