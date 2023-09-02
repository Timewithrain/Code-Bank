package my.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 */
public class CombinationSum {

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

    /** 2023.7.18 */
    static void firstTry() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = func(candidates, target);
        System.out.println(ans);
    }

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

    /** 2023.7.25 */
    static void secondTry() {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = func2(candidates, target);
        System.out.println(ans);
    }

    public static void main(String[] args) {
//        firstTry();
        secondTry();
    }
}
