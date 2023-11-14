package my.leet;

import java.util.HashSet;

/** 136. 只出现一次的数字 */
public class SingleNumber {

    static int func(int[] nums) {
        int ans = nums[0];
        int[] map = new int[60001];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map[nums[i] + 30000] += 1;
            if (map[nums[i] + 30000]==1) {
                set.add(nums[i]);
            } else {
                set.remove(nums[i]);
            }
        }
        Object[] a = set.toArray();
        ans = (int) a[0];
        return ans;
    }

    /** 标准答案： 使用异或实现 */
    static int func2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
