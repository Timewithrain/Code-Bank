package my.exam.ctrip;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 整数截取
 * 输入：
 * 10072
 * 输出：
 * 3
 * 输入：
 * 1440
 * 输出：
 * 3
 * 通过：0%
 */
public class SecondIntegerCut {

    static int toInt(int[] nums, int i, int j) {
        int ans = 0;
        if (i < j && nums[i] == 0) return -1;
        for (int k = i; k <= j; k++) {
            ans = ans * 10 + nums[k];
        }
        return ans;
    }

    static int func(String s) {
        int ans = 0;
        int l = s.length();
        int[] nums = new int[l];
        for (int i = 0; i < s.length(); i++)
            nums[i] = s.charAt(i) - '0';
        for (int j = l-1; j > 0; j--) {
            if (nums[j] == 0 || nums[j] == 2 || nums[j] == 4 || nums[j] == 6  || nums[j] == 8) {
                for (int i = j; i>=0 && j-i<10; i--) {
                    if (toInt(nums, i, j) % 72 == 0) {
                        System.out.println(toInt(nums, i, j));
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    static int getMod(String s, int i, int j) {
        if (i < j && s.charAt(i) == '0') return -1;
        BigDecimal b = new BigDecimal(s.substring(i, j+1));
        BigDecimal[] result = b.divideAndRemainder(new BigDecimal(72));
        return result[1].intValue();
    }

    static int func2(String s) {
        int ans = 0;
        int l = s.length();
        for (int j = l-1; j > 0; j--) {
            int c = s.charAt(j) - '0';
            if (c == 0 || c == 2 || c == 4 || c == 6  || c == 8) {
                for (int i = j; i>=0 && j-i<10; i--) {
                    if (getMod(s, i ,j) == 0) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = func2(s);
        System.out.println(ans);
    }
}
