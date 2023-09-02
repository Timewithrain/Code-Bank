package my.leet;

import java.util.ArrayList;

/** 376. 摆动序列 */
public class WiggleSubsequence {

    /** 贪心法 */
    static int func(int[] nums) {
        if (nums.length==1) return 1;
        if (nums.length==2) return nums[0]==nums[1] ? 1 : 2;
        ArrayList<Integer> list = new ArrayList<>();
        int pre = 0;
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            cur = nums[i]-nums[i-1];
            if (cur==0) continue;
            if (pre==0 || cur*pre<0) {
                list.add(cur);
                pre = cur;
            }
        }
        return list.size()+1;
    }

    /** 动态规划法 使用两个dp数组up和down分别记录在当前位置上以上或下摆动的序列的最大长度 */
    static int func2(int[] nums) {
        int l = nums.length;
        if (l==1) return 1;
        if (l==2) return nums[0]!=nums[1] ? 2 : 1;
        int[] up = new int[l];
        int[] down = new int[l];
        up[0] = 1;
        down[0] = 1;
        for (int i = 1; i < l; i++) {
            if (nums[i] > nums[i-1]) {  // 向上摆动
                up[i] = Math.max(up[i-1], down[i-1]+1);
                down[i] = down[i-1];
            } else if (nums[i] < nums[i-1]) {  // 向下摆动
                up[i] = up[i-1];
                down[i] = Math.max(up[i-1]+1, down[i-1]);
            } else {
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(up[l-1], down[l-1]);
    }

    public static void main(String[] args) {
        int[] nums = {1,7,4,9,2,5};
        System.out.println(func(nums));
    }
}
