package my.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 15. 三数之和. 给定一个数组，求出数组中任意三个数之和为0的三元组
 * 例如:
 * 输入: nums = [-1,0,1,2,-1,-4]
 * 输出: [[-1,0,1],[-1,-1,2]]
 */
public class TreeSum {

    /** 无效解，无法解决重复问题 */
    static boolean valid(HashMap<Integer, Integer> filter, int i, int j) {
        if (filter.containsKey(i) && filter.get(i)==j) return false;
        if (filter.containsKey(j) && filter.get(j)==i) return false;
        return true;
    }

    static List<List<Integer>> func1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> filter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i==j) continue;
                if (map.containsKey(-(nums[i]+nums[j])) && valid(filter, nums[i], nums[j]) &&
                        map.get(-(nums[i]+nums[j]))!=i && map.get(-(nums[i]+nums[j]))!=j) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(-(nums[i]+nums[j]));
                    filter.put(nums[i], nums[j]);
                    ans.add(list);
                    break;
                } else {
                    map.put(nums[j], j);
                }
            }
        }
        return ans;
    }

    /** 标准解法，排序后，使用左右指针 */
    static List<List<Integer>> func(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);  // 排序
        for (int i = 0; i < nums.length; i++) {  // 从左向右遍历，将当前元素作为三元组的第一个元素
            if (i>0 && nums[i]==nums[i-1]) continue;
            int l = i+1;  // 左指针，用于指向第二个元素
            int r = nums.length-1;    // 右指针，用于指向第三个元素
            while (l<r) {
                if (nums[i]+nums[l]+nums[r]==0) {  // 满足条件添加结果
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    ans.add(list);
                    while (l<r && nums[l]==nums[l+1]) l++;  // 跳过重复元素
                    while (l<r && nums[r]==nums[r-1]) r--;
                    l++; // 左指针右移
                    r--; // 右指针左移
                } else if (nums[i]+nums[l]+nums[r]<0) {  // 结果较小，左指针右移，值变大
                    l++;
                } else {  // 结果较大，右指针左移，值变小
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = func(nums);
        System.out.println(ans);
    }
}
