package my.leet;

import java.util.HashMap;

/** 219. 存在重复元素II */
public class ContainsDuplicateII {

    static boolean func(int[] nums, int k) {
        boolean ans = false;
        int l = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            if (map.containsKey(nums[i])) {
                if (Math.abs(map.get(nums[i]) - i) <= k) {
                    ans = true;
                    break;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,5,1}; // {1,0,1,1}; //
        int k = 3; // 1; //
        boolean ans = func(nums, k);
        System.out.println(ans);
    }
}
