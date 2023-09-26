package my.leet;

import my.leet.utils.ArrayUtils;

/** 997. 有序数组的平方 */
public class SquaresOfASortedArray {

    static int[] func(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        int t = 0;
        int i = 0;
        for (; i < l; i++)  // i记录最小非负数的位置
            if (nums[i]>=0) break;
        int j = i - 1;  // j记录最大负数的位置
        while (j>=0 && i<l) {
            if (-nums[j] > nums[i]) {  // 若负数绝对值大于正数绝对值则将正数取平方放入ans
                ans[t++] = nums[i] * nums[i];
                i++;
            } else {  // 否则将负数取平方放入ans
                ans[t++] = nums[j] * nums[j];
                j--;
            }
        }
        while (j >= 0) {  // 若有负数剩余，则继续将其放入ans
            ans[t++] = nums[j] * nums[j];
            j--;
        }
        while (i < l) {  // 若有正数数剩余，则继续将其放入ans
            ans[t++] = nums[i] * nums[i];
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1}; // {-7,-3,2,3,11}; // {-4,-1,0,3,10}; //
        int[] ans = func(nums);
        ArrayUtils.printArray(ans);
    }
}
