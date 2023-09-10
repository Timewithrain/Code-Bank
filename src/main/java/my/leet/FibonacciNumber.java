package my.leet;

public class FibonacciNumber {

    static int func(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        return func(n-1) + func(n-2);
    }

    static int func2(int n) {
        if (n==0) return 0;
        int a = 0;
        int b = 1;
        for (int i = 1; i < n; i++) {
            int t = b;
            b = a + b;
            a = t;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 0; // 10; // 4; // 3; // 2; //
        System.out.println(func(n));
        System.out.println(func2(n));
    }
}
