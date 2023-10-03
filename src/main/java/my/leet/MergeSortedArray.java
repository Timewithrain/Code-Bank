package my.leet;

import my.leet.utils.ArrayUtils;

/** 88. 合并两个有序数组 */
public class MergeSortedArray {

    static void func(int[] nums1, int m, int[] nums2, int n) {
        int[] n1 = new int[m];
        for (int i = 0; i < m; i++) {
            n1[i] = nums1[i];
        }
        int i = 0, j = 0, p = 0;
        while (i<m && j<n) {
            if (n1[i] < nums2[j]) {
                nums1[p++] = n1[i++];
            } else {
                nums1[p++] = nums2[j++];
            }
        }
        while (i<m) nums1[p++] = n1[i++];
        while (j<n) nums1[p++] = nums2[j++];
    }

    public static void main(String[] args){
        int[] a = {1,2,4,6,9};
        int[] nums2 = {3,5,6,7,10};
        int m = a.length;
        int n = nums2.length;
        int[] nums1 = new int[m+n];
        for (int i = 0; i < m; i++) {
            nums1[i] = a[i];
        }
        func(nums1, m, nums2, n);
        ArrayUtils.printArray(nums1);
    }
}
