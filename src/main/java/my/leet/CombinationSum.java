package my.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class CombinationSum {

    /**********************************  First Try  ****************************/

    static void f(int[] candidates, int pos, int target, int sum, List<Integer> tmp, List<List<Integer>> ans) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            sum += candidates[i];
            f(candidates, i, target, sum, tmp, ans);
            tmp.remove(tmp.size()-1);
            sum -= candidates[i];
        }
    }

    static List<List<Integer>> func(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        f(candidates, 0, target, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    /**********************************  Second Try  ****************************/

    static void f2(int[] candidates, int target, int pos, List<Integer> tmp, List<List<Integer>> ans) {
        if (target==0) {
            ans.add(new ArrayList<>(tmp));
            return;
        } else if (target<0) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            tmp.add(candidates[i]);
            f2(candidates, target-candidates[i], i, tmp, ans);
            tmp.remove(tmp.size()-1);
        }
    }

    static List<List<Integer>> func2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        f2(candidates, target, 0, tmp, list);
        return list;
    }

    /**********************************  Third Try  ****************************/

    static void dfs(int[] candidates, int target, int pos, ArrayList<Integer> tmp, int sum, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        if (pos==candidates.length || sum > target) return;
        int cur = 0;
        ArrayList<Integer> curList = new ArrayList<>();
        dfs(candidates, target, pos+1, tmp, sum, ans);
        while (cur <= target) {
            cur += candidates[pos];
            tmp.add(candidates[pos]);
            curList.add(candidates[pos]);
            dfs(candidates, target, pos+1, tmp, sum+cur, ans);
        }
        tmp.removeAll(curList);
    }

    static public List<List<Integer>> func3(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        dfs(candidates, target, 0, tmp, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        /** 2023.7.18 */
//        List<List<Integer>> ans = func(candidates, target);
        /** 2023.7.25 */
//        List<List<Integer>> ans = func2(candidates, target);
        /** 2023.9.16 */
        List<List<Integer>> ans = func3(candidates, target);
        System.out.println(ans);
    }
}
