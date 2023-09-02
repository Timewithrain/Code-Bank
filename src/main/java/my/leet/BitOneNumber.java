package my.leet;

/**
 * 191. 位1的个数
 */
public class BitOneNumber {

    static int func(int n) {
        int ans = 0;
        while(n!=0) {
            ans += n & 1;
            n = n >>> 1;  // 无符号右移
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        // int n = 0b11111111111111111111111111111101;
        int ans = func(n);
        System.out.println(ans);
    }
}
