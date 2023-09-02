package my.leet;

import java.util.HashSet;
import java.util.LinkedList;

public class RemoveElement {

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static int func(int[] nums, int val) {
        int r = nums.length - 1;
        int l = 0;
        if (r==l) {
            if (nums[l]==val) return l;
            return 1;
        }
        while (l<=r) {
            if (nums[l]==val) {
                swap(nums, l, r);
                r -= 1;
                continue;
            }
            l += 1;
        }
        return r+1;
    }

    public static void main(String[] args) {
        int[] nums = {2,3}; //{0,1,2,2,3,0,4,2}; //{3,2,2,3};
        int val = 3;
        int ans = func(nums, val);
        System.out.println(ans);
    }
}
