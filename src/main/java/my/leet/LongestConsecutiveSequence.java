package my.leet;

import java.util.HashMap;
import java.util.HashSet;


/** 128. 最长连续序列 */
public class LongestConsecutiveSequence {

    static int func(int[] nums) {
        int ans = 0;
        int l = nums.length;
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            } else if (map.containsKey(nums[i]+1) && map.containsKey(nums[i]-1)) {
                map.put(nums[i], new int[]{map.get(nums[i]-1)[1], map.get(nums[i]+1)[0]});
            } else if (map.containsKey(nums[i]+1)) {
                map.put(nums[i], new int[]{map.get(nums[i]+1)[0], map.get(nums[i]+1)[0]});
            } else if (map.containsKey(nums[i]-1)) {
                map.put(nums[i], new int[]{map.get(nums[i]-1)[1], map.get(nums[i]-1)[1]});
            } else {
                map.put(nums[i], new int[]{nums[i], nums[i]});
            }
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        HashSet<int[]> set = new HashSet<>();
        for (int[] range : map.values()) {
            if (range[0] == range[1]) {
                count.put(range[0], count.getOrDefault(range[0], 0) + 1);
            } else {
                set.add(range);
            }
        }
        for (int[] range : set) {
            int c = count.get(range[0]) + count.get(range[1]) + 1;
            count.put(range[0], c);
            count.put(range[1], c);
        }
        for (int c : count.values()) {
            ans = Math.max(ans, c);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {9,-1,4,-9,-3,0,-8,2,6,-4,-3,4,1,3,5,5,-7,-7,1,-9,-3,3,8,4,1,2}; // {0,3,7,2,5,8,4,6,0,1}; // {100, 4, 200, 1, 3, 2}; //
        int ans = func(nums);
        System.out.println(ans);
    }
}
