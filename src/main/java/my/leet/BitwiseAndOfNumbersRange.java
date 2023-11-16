package my.leet;

/** 201. 数字范围按位与 */
public class BitwiseAndOfNumbersRange {

    static boolean isBetween(long left, long right) {  // 判断left和right之间是否包含2的幂
        long t = 1;
        for (int i = 0; i < 32; i++) {
            if (left < t && t < right) {
                return true;
            }
            t = t << 1;
        }
        return false;
    }

    static int func(int left, int right) {
        if (left == right) return left;
        long ans = 0;
        long t = 1;
        for (int i = 0; i < 31; i++) {
            t = t << 1;
            if (t >= right) break;  // 找到大于等于right的最小2的指数幂
        }
        while (t>0) {
            ans += t & left & right;
            if (isBetween(left&(t-1), right&(t-1))) {  // 排除最高bit后，若剩余left到right的跨度中包含2的指数幂，则与结果必为0
                break;
            }
            t = t >>> 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int left = 2; // 5; // 1; // 2; // 2; //
        int right = 7; // 7; // 2147483647; // 3; // 7; //
        int ans = func(left, right);
        System.out.println(ans);
    }
}
