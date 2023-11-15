package my.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/** 373. 查找和最小的K对数字 */
public class FindKPairsWithSmallestSums {

    /** 双指针出错 */
    static List<List<Integer>> func(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int l1 = nums1.length, l2 = nums2.length;
        int i = 0, j = 0;
        while (k>0) {
            ans.add(new ArrayList<>(Arrays.asList(nums1[i], nums2[j])));
            k--;
            if (i==l1-1 || j==l2-1) {
                if (i==l1-1 && j==l2-1) break;
                if (i<l1-1) i++;
                if (j<l2-1) j++;
                continue;
            }
            if (nums1[i+1] + nums2[j] < nums1[i] + nums2[j+1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    /** 标准解法：堆 */
    static List<List<Integer>> func2(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (o1,o2) -> {
            return (nums1[o1[0]] + nums2[o1[1]]) - (nums1[o2[0]] + nums2[o2[1]]);
        });
        int l1 = nums1.length, l2 = nums2.length;
        for (int i = 0; i < l1; i++) {  // 将(ai,0)全部放入堆中
            pq.add(new int[]{i, 0});
        }
        while (k>0 && !pq.isEmpty()) {
            int[] idx = pq.poll();
            ans.add(new ArrayList<>(Arrays.asList(nums1[idx[0]], nums2[idx[1]])));
            if (idx[1] < l2-1) {
                pq.add(new int[]{idx[0], idx[1]+1});  // 每取一个将(ai,bi+1)放入堆中，保证获取到最小组合
            }
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2}; // {1,1,2}; // {1,7,11}; //
        int[] nums2 = {3}; // {1,2,3}; // {2,4,6}; //
        int k = 10; // 3; // 3; //
        List<List<Integer>> ans = func2(nums1, nums2, k);
        System.out.println(ans);
    }
}
