package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.HashMap;

/**
 * 1. 两数之和
 */
public class TwoSum {

    static int[] func(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                ans[0] = i;
                ans[1] = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,5};
        int target = 9;
        int[] ans = func(nums, target);
        ArrayUtils.printArray(ans);
    }

}
