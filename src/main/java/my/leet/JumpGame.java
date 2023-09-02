package my.leet;

/** 55. 跳跃游戏 */
public class JumpGame {

    static boolean func(int[] nums) {
        if (nums.length==1) return true;
        int i = 0;
        int range = nums[0];
        while (range<nums.length-1) {
            int next = 0;
            for (int j = i; j <= i + nums[i]; j++) {
                if (j + nums[j] > range) {
                    next = j;
                    range = j + nums[j];
                }
            }
            if (next==0) return false;
            i = next;
            range = i + nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};  //{2,3,1,1,4}; // {3,2,1,0,4};
        System.out.println(func(nums));
    }
}
