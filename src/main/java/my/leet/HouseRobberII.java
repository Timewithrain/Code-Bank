package my.leet;

/** 213. 打家劫舍II */
public class HouseRobberII {

    static int func(int[] nums) {
        int l = nums.length;
        if (l==1) return nums[0];
        if (l==2) return Math.max(nums[0], nums[1]);
        if (l==3) return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        if (l==4) return Math.max(nums[0]+nums[2], nums[1]+nums[3]);
        int[] dp1 = new int[l];
        dp1[1] = nums[1];
        dp1[2] = Math.max(nums[1], nums[2]);
        dp1[3] = Math.max(nums[1]+nums[3], nums[2]);
        for (int i = 4; i < l; i++) {
            dp1[i] += Math.max(dp1[i-1], Math.max(dp1[i-3], dp1[i-2]) + nums[i]);
        }
        int[] dp2 = new int[l];
        dp2[0] = dp2[1] = nums[0];
        dp2[2] = nums[0] + nums[2];
        dp2[3] = dp2[0] + Math.max(nums[2], nums[3]);
        for (int i = 4; i < l-1; i++) {
            dp2[i] += Math.max(dp2[i-1], Math.max(dp2[i-3], dp2[i-2]) + nums[i]);
        }
        return Math.max(dp1[l-1], dp2[l-2]);
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,7,5,3,1}; // {1,3,1,3,100}; // {2,7,9,3,1}; // {1,2,3}; // {1,2,3,1}; //
        System.out.println(func(nums));
    }
}
