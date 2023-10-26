package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 228. 汇总区间 */
public class SummaryRanges {

    static List<String> func(int[] nums) {
        List<String> ans = new ArrayList<>();
        int l = nums.length;
        if (l==0) return ans;
        int[] range = {nums[0], nums[0]};
        for (int i = 1; i < l; i++) {
            if (nums[i] == nums[i-1] + 1) {
                range[1] = nums[i];
            } else {
                if (range[0]==range[1]) {
                    ans.add(String.valueOf(range[0]));
                } else {
                    ans.add(range[0] + "->" + range[1]);
                }
                range = new int[]{nums[i], nums[i]};
            }
        }
        if (range[0]==range[1]) {
            ans.add(String.valueOf(range[0]));
        } else {
            ans.add(range[0] + "->" + range[1]);
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {0,2,3,4,6,8,9}; // {0,1,2,4,5,7}; //
        List<String> ans = func(nums);
        System.out.println(ans);
    }
}
