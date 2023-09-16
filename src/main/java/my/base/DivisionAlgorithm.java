package my.base;

/**
 * 辗转相除法求最大公因数和最小公倍数
 */
public class DivisionAlgorithm {


    public static void main(String[] args) {
        int a = 100;
        int b = 80;
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (max % min > 0) {  // 辗转相除法
            int rest = max % min;
            max = min;
            min = rest;
        }
        System.out.println("最大公因数:" + min);
        System.out.println("最小公倍数:" + (a*b)/min);
    }
}
