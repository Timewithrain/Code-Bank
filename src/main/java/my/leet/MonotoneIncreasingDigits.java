package my.leet;

/** 738. 单调递增的数字 */
public class MonotoneIncreasingDigits {

    static int toInt(int[] num, int idx) {
        int n = 0;
        for (int i = 0; i < num.length; i++) {
            if (i<=idx) {
                n = n * 10 + num[i];
            } else {
                n = n * 10 + num[idx];
            }
        }
        return n;
    }

    static int func(int n) {
        String s = n+"";
        int l = s.length();
        int[] a = new int[l];
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '0';
        }
        for (int i = 0; i < l; i++) {
            if (i == 0 && toInt(a, i) > n) {
                a[i] -= 1;
            }
            if (i>0) {
                a[i] = 9;
                while (toInt(a, i) > n && a[i]>a[i-1]) {
                    a[i] -= 1;
                }
            }
        }
        return toInt(a, l);
    }

    public static void main(String[] args) {
        int n = 120; // 332; // 10; // 1234; //
        System.out.println(func(n));
    }
}
