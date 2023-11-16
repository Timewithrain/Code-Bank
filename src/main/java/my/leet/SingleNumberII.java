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

    /** 计算每个bit位上1的个数，除以3以后即为仅出现一次的数对应bit位的值 */
    static int func2(int[] nums) {
        int ans = 0;
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bits[j] += nums[i] & 1;
                nums[i] = nums[i] >>> 1;
            }
        }
        int t = 1;
        for (int i = 0; i < 32; i++) {
            bits[i] = bits[i] % 3;
            ans += bits[i] * t;
            t = t << 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,2};
        int ans = func2(nums);
        System.out.println(ans);
    }
}
