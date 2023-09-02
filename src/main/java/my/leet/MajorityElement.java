package my.leet;

import java.util.Arrays;

/** 169. 多数元素 */
public class MajorityElement {

    /** 由于多数元素数量>2/n，排序后中位数必为多数元素，时间复杂度O(nlogn), 空间复杂度O(1) */
    static int func(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /** Boyer-Moore算法，时间复杂度O(n), 空间复杂度O(1) */
    static int func2(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(func2(nums));
    }
}
