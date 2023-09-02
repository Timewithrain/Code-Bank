package my.leet;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 46. 全排列
 */
public class AllPermutation {

    static void f(int pos, List<Integer> tmp, List<List<Integer>> ans) {
        if (pos == tmp.size()) {
            ans.add(new ArrayList<>(tmp));
        }
        for (int i = pos; i < tmp.size(); i++) {
            Collections.swap(tmp, pos, i);
            f(pos+1, tmp, ans);
            Collections.swap(tmp, pos, i);
        }
    }

    static List<List<Integer>> func(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            tmp.add(nums[i]);
        }
        f(0, tmp, ans);
        return ans;
    }

    static void firstTry() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = func(nums);
        System.out.println(ans);
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    static void f2(int[] nums, int pos, List<List<Integer>> ans) {
        if (pos==nums.length) {
            // 使用流操作，将Array[int]转化为Array[Integer]再转化为List<Integer>
            List<Integer> tmp = Arrays.stream(nums).boxed().collect(Collectors.toList());
            ans.add(tmp);
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums, pos, i);
            f2(nums, pos+1, ans);
            swap(nums, pos, i);
        }
    }

    static List<List<Integer>> func2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f2(nums, 0, ans);
        return ans;
    }

    static void secondTry() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = func2(nums);
        System.out.println(ans);
    }

    public static void main(String[] args) {
        /** 2023.7.18 耗时: 1ms */
//        firstTry();
        /** 2023.7.25 耗时: 3ms */
        secondTry();
    }
}


