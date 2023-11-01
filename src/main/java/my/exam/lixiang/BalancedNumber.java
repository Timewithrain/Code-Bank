package my.exam.lixiang;

import my.leet.utils.ArrayUtils;

import java.util.Scanner;

public class BalancedNumber {

    static void func() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String num = n+"";
        int l = num.length();
        boolean balanced = false;
        int[] left = new int[l];
        int[] right = new int[l];
        left[0] = num.charAt(0) - '0';
        for (int i = 1; i < l; i++) {
            left[i] = left[i-1] * (num.charAt(i) - '0');
        }
        right[l-1] = num.charAt(l-1) - '0';
        for (int i = l-2; i >= 0; i--) {
            right[i] = right[i+1] * (num.charAt(i) - '0');
        }
        for (int i = 0; i < l-1; i++) {
            if (left[i]==right[i+1]) {
                balanced = true;
                break;
            }
        }
        if (balanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }


    public static void main(String[] args) {
        func();
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        String num = n+"";
//        int l = num.length();
//        long left = num.charAt(0) - '0';
//        long right = 1;
//        boolean balanced = false;
//        int cnt = 0;
//        for (int i = 0; i < l; i++) {
//            if (num.charAt(i)=='0') cnt++;
//        }
//        if (cnt>1) {  // 判断0的情况
//            System.out.println("YES");
//            return;
//        }
//        for (int i = l-1; i > 0 ; i--) {
//            right *= num.charAt(i) - '0';
//        }
//        for (int i = 1; i < l-1; i++) {
//            int ni = num.charAt(i) - '0';
//            if (left == right) {
//                balanced = true;
//                break;
//            } else {
//                left = left * ni;
//                right = right / ni;
//            }
//        }
//        if (left == right) {
//            balanced = true;
//        }
//        if (balanced) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
    }
}
