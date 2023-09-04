package my.leet;

import java.util.Comparator;
import java.util.PriorityQueue;

/** 1005. K次取反后最大化的数组和 */
public class MaximizeSumOfArrayAfterKNegations {

    static int func(int[] nums, int k) {
        int ans = 0;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {  // 构建小根堆
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });
        int min_idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                queue.add(new Integer[]{nums[i], i});  // 记录所有负数
            }
            if (Math.abs(nums[i]) < Math.abs(nums[min_idx])) {  // 记录绝对值最小值的下标
                min_idx = i;
            }
            ans += nums[i];
        }
        if (queue.size() > 0) {  // 若有负数，在k耗尽前将较小的负数变为正数
            while (k>0 && !queue.isEmpty()) {
                Integer[] tmp = queue.poll();
                ans += -2 * tmp[0];
                nums[tmp[1]] = -nums[tmp[1]];  // 对原值取反，以便后续计算
                k--;
            }
        }
        if (k%2!=0) {  // 若k未耗尽且k剩余为奇数，将绝对值最小的数作取反操作
            ans += -2 * nums[min_idx];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,6,9,-3,3}; // {2,-3,-1,5,-4}; // {4,2,3}; // {3,-1,0,2}; // {-2,9,9,8,4}; // {2,-3,-1,5,-4}; //
        int k = 2; // 2; // 1; // 3; // 5; // 2; //
        System.out.println(func(nums, k));
    }
}
