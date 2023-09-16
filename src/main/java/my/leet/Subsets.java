package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 78. 子集 */
public class Subsets {

    static List<List<Integer>> func(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> cur = new ArrayList<>();
            for (int j = 0; j < ans.size(); j++) {
                List<Integer> tmp = new ArrayList<>(ans.get(j));
                tmp.add(nums[i]);
                cur.add(tmp);
            }
            ans.addAll(cur);
        }
        return ans;
    }

    public static void main(String[] args){

    }
}
