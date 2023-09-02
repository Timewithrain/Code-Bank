package my.leet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 78. 子集
 */
public class Subset {

    /** 动态规划
     *  Leetcode用时0ms，击败100%；内存:40.9MB，击败57.09%
     */
    static List<List<Integer>> dp(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmp = new ArrayList<>();
            for (List t : ans) {
                ArrayList<Integer> tt = new ArrayList<>(t);
                tt.add(nums[i]);
                tmp.add(tt);
            }
            ans.addAll(tmp);
        }
        return ans;
    }

    /** 回溯法调用dfs搜索 */
    static void dfs(int[] nums, int pos, List<Integer> tmp, List<List<Integer>> ans) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[pos]);
        dfs(nums, pos+1, tmp, ans);
        tmp.remove(tmp.size()-1);
        dfs(nums, pos+1, tmp, ans);
        return;
    }

    /** 回溯法 */
    static List<List<Integer>> traceBack(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums, 0, tmp, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
//        List<List<Integer>> ans = dp(nums);  // 动态规划
        List<List<Integer>> ans = traceBack(nums);  // 回溯
        System.out.println(ans);

    }

}
