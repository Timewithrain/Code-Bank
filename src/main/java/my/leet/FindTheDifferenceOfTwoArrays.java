package my.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/** 2215. 找出两组数的不同 */
public class FindTheDifferenceOfTwoArrays {

    static List<List<Integer>> func(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        HashSet<Integer> a1 = new HashSet<>();
        HashSet<Integer> a2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            s1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            s2.add(nums2[i]);
            if (!s1.contains(nums2[i])) a2.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (!s2.contains(nums1[i])) a1.add(nums1[i]);
        }
        ans.add(new ArrayList<>(a1));
        ans.add(new ArrayList<>(a2));
        return ans;
    }

    public static void main(String[] args){

    }
}
