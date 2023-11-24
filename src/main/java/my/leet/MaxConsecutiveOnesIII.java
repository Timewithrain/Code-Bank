package my.leet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/** 1004. 最大连续1的个数III */
public class MaxConsecutiveOnesIII {

    static int dfs(ArrayList<Integer> list, int i, int k, int ans) {
        if (i >= list.size()) return ans;
        if (k==0) return i>0 ? list.get(i-1) + ans : ans;
        int preOne = i>0 ? list.get(i-1) : 0;
        int zero = list.get(i);
        if (k  >=  list.get(i)) {
            ans = Math.max(ans, dfs(list, i+2, k-list.get(i), ans+preOne+zero));
        } else {
            ans += preOne + k;
        }
        return ans;
    }

    static int func(int[] nums, int k) {
        int ans = 0;
        int l = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        int cnt = 1;
        for (int i = 1; i < l; i++) {
            if (nums[i-1] == nums[i]) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
            }
        }
        list.add(cnt);
        if (k==0 && list.size()==1) return nums[0]==0 ? 0 : list.get(0);
        int i = nums[0]==0 ? 0:1;
        for (; i < list.size(); i+=2) {
            ans = Math.max(ans, dfs(list, i, k, 0));
        }
        Collections.reverse(list);
        i = nums[l-1]==0 ? 0:1;
        for (; i < list.size(); i+=2) {
            ans = Math.max(ans, dfs(list, i, k, 0));
        }
        return ans;
    }

    public static void main(String[] args){
        int[] nums = {0}; // {1,1,1}; // {0,0,0,1}; // {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}; // {1,1,1,0,0,0,1,1,1,1,0}; //
        int k = 1; // 4; // 3; // 2; //
        int ans = func(nums, k);
        System.out.println(ans);
    }
}
