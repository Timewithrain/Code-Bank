package my.leet;

import my.leet.utils.ArrayUtils;

/** 167. 两数之和II - 输入有序数组 */
public class TwoSumIIInputArrayIsSorted {

    /** 双指针法 */
    static int[] func(int[] numbers, int target) {
        int[] ans = new int[2];
        int l = 0, r = numbers.length-1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4}; // {2,7,11,15}; //
        int target = 6; // 9; //
        int[] ans = func(nums, target);
        ArrayUtils.printArray(ans);
    }
}
