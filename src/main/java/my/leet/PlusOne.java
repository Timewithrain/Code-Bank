package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.ArrayList;

/** 66. 加一 */
public class PlusOne {

    static int[] func(int[] digits) {
        int l = digits.length;
        ArrayList<Integer> ans = new ArrayList<>();
        digits[l-1] += 1;
        int carry = 0;
        for (int i = l-1; i >= 0; i--) {
            ans.add((digits[i] + carry) % 10);
            carry = (digits[i] + carry) / 10;
        }
        if (carry > 0) ans.add(carry);
        int[] ansArr = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            ansArr[i] = ans.get(ans.size()-i-1);
        }
        return ansArr;
    }

    public static void main(String[] args){
        int[] digits = {9};
        int[] ans = func(digits);
        ArrayUtils.printArray(ans);
    }
}
