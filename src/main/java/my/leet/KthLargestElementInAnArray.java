package my.leet;

import java.util.PriorityQueue;

/** 215. 数组中的第K个最大元素 */
public class KthLargestElementInAnArray {

    static int func(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();  // 使用优先级队列实现，默认排序(头->尾)为从小到大
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {  // 保证队列长度为K
                queue.poll();
            }
        }
        return queue.peek();  // 获取队头即可拿到第K大的元素
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6}; // {3,2,1,5,6,4}; //
        int k = 4;  // 2; //
        int ans = func(nums, k);
        System.out.println(ans);
    }
}
