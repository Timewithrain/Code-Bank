package my.leet;

import my.leet.utils.ArrayUtils;

/**
 * 189. 轮转数组
 * 以l-k个节点为分界线，两部分分别逆序，再求整体逆序，即可完成轮转
 */
public class RotateArray {

    static void swap(int[] nums , int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void reverse(int[] nums, int start, int end) {
        int mid = (start + end) / 2;
        if ((start + end) % 2 ==0) {
            for (int i = 1; mid + i <= end; i++) {
                swap(nums, mid-i, mid+i);
            }
        } else {
            for (int i = 0; i <= mid - start; i++) {
                swap(nums, start+i, end - i);
            }
        }
    }

    static void func(int[] nums, int k) {
        int l = nums.length;
        k = k % l;
        if (l==1) return;
        reverse(nums, 0, l-k-1);
        reverse(nums, l-k, l-1);
        reverse(nums, 0, l-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2}; // {1,2,3,4,5,6,7}; //
        func(nums, 3);
        ArrayUtils.printArray(nums);
    }
}
