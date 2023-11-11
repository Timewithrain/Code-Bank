package my.leet;

/** 190. 颠倒二进制位 */
public class ReverseBits {

    static int bits = 32;  // 定义二进制位数

    static void printBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bits; i++) {
            int num = (n & (1 << i)) == 0 ? 0 : 1;
            sb.append(""+num);
        }
        System.out.println(sb.reverse().toString());
    }

    static int func(int n) {
        int ans = 0;
        int mv = bits - 1;
        int i = 1 << mv;
        for (int j = 0; j <= mv; i = i >>> 1, j++) {  // i必须使用无符号右移
            int tmp = (n & i) == 0 ? 0 : 1;
            ans += tmp << j;
        }
        return ans;
    }

    public static void main(String[] args){
        bits = 32;
        int n = Integer.valueOf("111000111000", 2); // "0111" // 43261596; // "00000010100101000001111010011100" //
        System.out.println("n: " + n);
        printBinary(n);
        int ans = func(n);
        printBinary(ans);
    }
}
