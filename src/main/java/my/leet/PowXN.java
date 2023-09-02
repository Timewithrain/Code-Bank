package my.leet;

/** 50.Pow(x,n) */
public class PowXN {

    static double pow(double x, long n) {
         if (n==0) return 1;
         if (n<0) return 1 / pow(x, -n);
         if (n%2==0) {
             double t = pow(x, n/2);
             return t*t;
         } else {
             return x * pow(x, n-1);
         }
    }

    static double MyPow(double x, long n) {
        return pow(x, n);
    }

    public static void main(String[] args) {
        double x = 1;
        int n = -2147483648;
        System.out.println(pow(x, n));
        System.out.println();
    }
}
