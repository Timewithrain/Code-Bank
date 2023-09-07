package my.exam.ctrip;

import java.util.Scanner;

/**
 * 小游的好串
 * 给定一个完全由01组成的字符串，求其所有子串中是好子串的个数
 * 好串的定义：一个字符串的所有前缀都严格遵守0的个数多余1的个数
 *
 */
public class YouGoodString {

    static boolean isGood(int[] zero, int[] one, int i , int j) {
        for (int k = j; k <= i; k++) {
            int z = j>0 ? zero[k]-zero[j-1] : zero[0];
            int o = j>0 ? one[k]-one[j-1] : one[0];
            if (z <= o) {
                return false;
            }
        }
        return true;
    }

    static int func(String s) {
        int l = s.length();
        int[] zero = new int[l];
        int[] one = new int[l];
        zero[0] = s.charAt(0) == '0' ? 1 : 0;
        one[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < l; i++) {
            if  (s.charAt(i)=='0') {
                zero[i] = zero[i-1] + 1;
                one[i] = one[i-1];
            } else {
                zero[i] = zero[i-1];
                one[i] = one[i-1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j <= i; j++) {
                if (isGood(zero, one, i, j)) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(func(s));
    }
}
