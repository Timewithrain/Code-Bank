package my.exam.tuhu;

import java.util.Arrays;

/**
 * 2. 判断给定数组nums中能组成三角形的三元组个数
 * 通过100%
 */
public class ValidTriangleNumber {

    public static int validTriangle (int[] nums) {
        int ans = 0;
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = len-1; i >=2 ; i--) {
            int l = 0;
            int r = i-1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    ans += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
