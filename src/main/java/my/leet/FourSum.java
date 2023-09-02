package my.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和. 给定一个数组，求出数组中任意四个数之和为target的四元组
 */
public class FourSum {

    static List<List<Integer>> func(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {  // 确定第一个元素
            if (i>0 && nums[i]==nums[i-1]) continue;  // 去重
            for (int j = i+1; j < nums.length-2; j++) {    // 确定第二个元素
                if (j>i+1 && nums[j]==nums[j-1]) continue;  // 去重
                int l = j+1;
                int r = nums.length-1;
                while (l<r) {  // 左右指针确定第三和第四个元素
                    if ((double) (nums[i] + nums[j]) == target - (double) (nums[l] + nums[r])) {  // 使用double类型解决溢出问题
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        ans.add(list);
                        while (l+1<r && nums[l]==nums[l+1]) l++;
                        while (l<r-1 && nums[r]==nums[r-1]) r--;
                        l++;
                        r--;
                    } else if ((double) (nums[i] + nums[j]) < target - (double) (nums[l] + nums[r])) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2}; // {2,2,2,2,2};  // {1000000000,1000000000,1000000000,1000000000}; //
        int target = 0;  // 8;  // -294967296; //
        List<List<Integer>> ans = func(nums, target);
        System.out.println(ans);
    }
}
