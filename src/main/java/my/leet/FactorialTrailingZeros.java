package my.leet;

/** 173. 阶乘后的零 */
public class FactorialTrailingZeros {

    static int getTwo(int n) {
        int ans = 0;
        while (n>0 && n%2 == 0) {
            ans++;
            n = n / 2;
        }
        return ans;
    }

    static int getFive(int n) {
        int ans = 0;
        while (n>0 && n%5 == 0) {
            ans++;
            n = n / 5;
        }
        return ans;
    }

    static int func(int n) {
        int two = 0;
        int fiv = 0;
        for (int i = 1; i <= n; i++) {
            two += getTwo(i);
            fiv += getFive(i);
        }
        return Math.min(two, fiv);
    }

    static int func2(int n) {
        int[] fiv = new int[n+1];
        int ans = 0;
        if (n>=5) {
            fiv[5] = 1;
            ans = 1;
        }
        for (int i = 6; i <= n; i++) {
            if (i%5 == 0) fiv[i] += fiv[i/5] + fiv[i/(i/5)];
            ans += fiv[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 30; // 6;
        int ans = func(n);
        System.out.println(ans);
        ans = func2(n);
        System.out.println(ans);
    }
}
