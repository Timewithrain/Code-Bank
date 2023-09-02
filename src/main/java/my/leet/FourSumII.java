package my.leet;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 */
public class FourSumII {

    static int func(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (!map1.containsKey(nums1[i]+nums2[j]))
                    map1.put(nums1[i]+nums2[j], 1);
                else
                    map1.put(nums1[i]+nums2[j], map1.get(nums1[i]+nums2[j])+1);
                if (!map2.containsKey(nums3[i]+nums4[j]))
                    map2.put(nums3[i]+nums4[j], 1);
                else
                    map2.put(nums3[i]+nums4[j], map2.get(nums3[i]+nums4[j])+1);
            }
        }
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(-key)) {
                ans += map1.get(key) * map2.get(-key);
            }
        }
        return ans;
    }


    public static void main(String[] args){
        int[] nums1 = {1,2};
        int[] nums2 = {-2,-1};
        int[] nums3 = {-1,2};
        int[] nums4 = {0,2};
        System.out.println(func(nums1, nums2, nums3, nums4));
    }
}
