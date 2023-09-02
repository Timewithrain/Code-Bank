package my.leet;

/**
 * 152. 最大乘积子数组
 */
public class MaximumProductSubarray {

    public static int func(int[] nums) {
        int l = nums.length;
        int ans = 0;
        int[] pos = new int[l];
        int[] neg = new int[l];
        pos[0] = nums[0];
        neg[0] = nums[0];
        for(int i=1; i<l; i++) {
            if (nums[i]>0) {
                pos[i] = Math.max(pos[i-1] * nums[i], nums[i]);
                neg[i] = Math.min(neg[i-1] * nums[i], nums[i]);
            } else if (nums[i]<0) {
                pos[i] = Math.max(neg[i-1] * nums[i], nums[i]);
                neg[i] = Math.min(pos[i-1] * nums[i], nums[i]);
            } else {
                pos[i] = nums[i];
                neg[i] = nums[i];
            }
            if (ans<pos[i]) {
                ans = pos[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,-1};// {1,3,-2,-4,5};
        System.out.println(func(nums));
    }
}
