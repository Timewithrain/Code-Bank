package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.ArrayList;

/**
 * 349. 两个数组的交集
 */
public class IntersectionOfTwoArrays {

    static int[] func(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] map1 = new int[1001];
        int[] map2 = new int[1001];
        for (int i = 0; i < nums1.length || i < nums2.length; i++) {
            if (i<nums1.length) map1[nums1[i]]++;
            if (i<nums2.length) map2[nums2[i]]++;
        }
        for (int i = 0; i < map1.length; i++) {
            if (map1[i]!=0 && map2[i]!=0) list.add(i);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    public static void main(String[] args) {
        int[] nums1 = {4,9,5}; // {1,2,2,1};  //
        int[] nums2 = {9,4,9,8,4}; //{2,2};  //
        int[] ans = func(nums1, nums2);
        ArrayUtils.printArray(ans);
    }
}
