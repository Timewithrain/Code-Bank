package my.leet;

/** 191. 位1的个数 */
public class NumberOfOneBits {

    static int func(int n) {
        int ans = 0;
        while (n != 0) {
            ans += n & 1;
            n = n >>> 1;  // 使用无符号右移
        }
        return ans;
    }

    public static void main(String[] args){
        int n = 3;
        int ans = func(n);
        System.out.println(ans);
    }
}
