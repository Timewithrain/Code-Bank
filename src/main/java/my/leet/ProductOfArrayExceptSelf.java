package my.leet;

import my.leet.utils.ArrayUtils;

/** 238. 除以自身以外数组的乘积 */
public class ProductOfArrayExceptSelf {

    /** 使用除法 */
    static int[] func(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        int zero = 0;
        long standard = 1;
        for (int i = 0; i < l; i++) {
            if (nums[i] != 0) {
                standard *= nums[i];
            } else {
                zero++;
            }
            if (zero > 1) {
                return ans;
            }
        }
        for (int i = 0; i < l; i++) {
            if (zero == 0) {
                ans[i] = (int) (standard / (long) nums[i]);
            } else {
                ans[i] = nums[i] == 0 ? (int) standard : 0;
            }
        }
        return ans;
    }

    /** 不使用除法，前缀后缀数组实现。时间复杂度: O(n) 空间复杂度O(n)
     * 该方法可继续优化，将省去后缀数组，用一个变量R记录后缀乘积，优化后时间复杂度：O(n) 空间复杂度：O(1)
     */
    static int[] func2(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        ans[0] = 1;
        for (int i = 1; i < l; i++) {  // 记录前缀乘积
            ans[i] = ans[i-1] * nums[i-1];
        }
        int[] tmp = new int[l];
        tmp[l-1] = 1;
        for (int i = l-2; i >= 0; i--) {  // 记录后缀乘积
            tmp[i] = tmp[i+1] * nums[i+1];
            ans[i] *= tmp[i];  // 前缀和后缀求积
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3}; // {1,0}; // {1,2,3,4}; //
        int[] ans = func(nums);
        ArrayUtils.printArray(ans);
        int[] ans2 = func2(nums);
        ArrayUtils.printArray(ans2);

    }
}
