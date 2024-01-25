package my.leet;

/** 643. 子数组最大平均数I */
public class MaximumAverageSubarrayI {

    static double func(int[] nums, int k) {
        int l = nums.length;
        int sum = 0;
        for (int i = 0; i < k && i < l; i++) {
            sum += nums[i];
        }
        double ans = sum;
        for (int i = k; i < l; i++) {
            sum = sum+nums[i]-nums[i-k];
            ans = (double) Math.max(ans, sum);
        }
        return ans / k;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,1,3,3}; // {1,12,-5,-6,50,3}; //
        int k = 2; // 4; //
        double ans = func(nums, k);
        System.out.println(ans);
    }
}
