package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 80. 删除有序数组中的重复项II
 * 要求：重复项最多保留两个
 */
public class RemoveDuplicatesFromSortedArrayII {

    /** 重复项最多保留两个 */
    static int func(int[] nums) {
        int l = nums.length;
        if (l<3) return l;
        int ans = 0;
        int p = 2, q = 2;
        while (q < l) {
            if (nums[p-2] != nums[q]) {
                nums[p] = nums[q];
                p++;
            }
            q++;
        }
        ans = p;
        return ans;
    }

    /** 重复项最多保留k个 */
    static int func2(int[] nums, int k) {
        int l = nums.length;
        if (l<k+1) return l;
        int ans = 0;
        int p = k, q = k;
        while (q < l) {
            if (nums[p-k] != nums[q]) {
                nums[p] = nums[q];
                p++;
            }
            q++;
        }
        ans = p;
        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = {0,0,1,1,1,1,2,3,3,3,4}; // {1,2,3,3,3,4,4,5,6,7,7,7,8,9}; //
//        int k = 3;
//        int ans = func(nums);
//        System.out.println(ans);
//        for (int i = 0; i < ans; i++) {
//            System.out.printf("%d ", nums[i]);
//        }

//        TreeMap<String, Integer> map = new TreeMap<>();
//        ConcurrentSkipListMap<String, Integer> map = new ConcurrentSkipListMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("null", null);
        System.out.println(map.get("null"));
    }
}
