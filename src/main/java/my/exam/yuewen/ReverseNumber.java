package my.exam.yuewen;

import java.util.Scanner;

/** 2. 判断回文数 */
public class ReverseNumber {

    static boolean func(String num) {
        boolean ans = true;
        int l = num.length();
        for (int i = 0; i < l/2; i++) {
            if (num.charAt(i) != num.charAt(l-1-i)) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        boolean ans = func(num+"");
        System.out.println(ans);
    }
}
