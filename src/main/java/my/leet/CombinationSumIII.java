package my.leet;

import java.util.ArrayList;
import java.util.List;

/** 216. 组合总和III */
public class CombinationSumIII {

    static void dfs(int i, int limit, int cur, int n, int k, List<Integer> a, List<List<Integer>> ans) {
        if (cur==n && a.size()==k) {
            ans.add(new ArrayList<>(a));
        } else {
            for (int j = i+1; j <= limit; j++) {
                if (cur + j <= n && a.size()<k) {
                    a.add(j);
                    dfs(j, limit, cur+j, n, k, a, ans);
                    if (a.size()>0) a.remove(a.size()-1);
                } else {
                    break;
                }
            }
        }
    }

    static List<List<Integer>> func(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        dfs(0, 9,0, n, k, a, ans);
        return ans;
    }

    public static void main(String[] args){
        int k = 3; // 3;
        int n = 9; // 7;
        List<List<Integer>> ans = func(k, n);
        System.out.println(ans);
    }
}
