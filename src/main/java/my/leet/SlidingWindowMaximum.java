package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    /** 标准解法 使用大根堆对滑动窗口内的值排序 */
    static int[] func(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 默认为小根堆，重写排序逻辑为大根堆，数字降序排序，若数字相同则按索引降序排序
                return o2[0] != o1[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i<k && i<nums.length; i++) {
            heap.add(new int[]{nums[i], i});  // 数组[0]存储数值，数组[1]存储数值在nums中的索引
        }
        list.add(heap.peek()[0]);
        for (int i = k; i < nums.length; i++) {
            heap.add(new int[]{nums[i], i});
            int[] t = heap.peek();
            while(t[1] <= i-k) {
                heap.poll();
                t = heap.peek();
            }
            list.add(t[0]);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // O(nk)时间复杂度 超时
    static int[] func1(int[] nums, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        int i = 0;
        for (; i<k && i<nums.length; i++) {
            if (nums[i]>max) max = nums[i];
        }
        list.add(max);
        for (; i < nums.length; i++) {
            if (nums[i]<list.get(list.size()-1)) {  // 前一个最大值
                max = nums[i];
                for (int j = i-k+1; j < i; j++) {
                    if (nums[j]>max) max = nums[j];
                }
                list.add(max);
            } else {
                list.add(nums[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = func(nums, k);
        ArrayUtils.printArray(ans);
    }

}
