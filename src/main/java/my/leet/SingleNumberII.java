package my.leet;

import java.util.HashMap;
import java.util.Map;

/** 137. 只出现一次的数字II */
public class SingleNumberII {

    static int func(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1) {
                ans = entry.getKey();
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
