package my.exam.yuewen;

import java.util.ArrayList;

/** 1. 乘积为正的最长连续子数组 */
public class PositiveMultipleSubarray {

    public int func2 (ArrayList<Integer> nums) {
        int l = nums.size();
        int[] pos = new int[l];
        int[] neg = new int[l];
        pos[0] = nums.get(0)>0 ? 1:0;
        neg[0] = nums.get(0)<0 ? 1:0;
        int ans = pos[0];
        for (int i = 1; i < l; i++) {
            if (nums.get(i) > 0) {
                pos[i] = pos[i-1] + 1;
                neg[i] = neg[i-1]>0 ? neg[i-1]+1:0;
            } else if (nums.get(i) < 0) {
                pos[i] = neg[i-1]>0 ? neg[i-1]+1:0;
                neg[i] = pos[i-1] + 1;
            } else {
                pos[i] = 0;
                neg[i] = 0;
            }
            ans = Math.max(ans, pos[i]);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
