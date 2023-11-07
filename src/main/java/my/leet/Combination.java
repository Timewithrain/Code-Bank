package my.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** 77. 组合 */
public class Combination {

    static void dfs(int i, int n, int k, int pos, int[] tmp, List<List<Integer>> ans) {
        if (n-i < k-pos) return;
        if (pos==k) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < k; j++) list.add(tmp[j]);
            ans.add(list);
            return;
        }
        for (int j = i+1; j <= n; j++) {
            tmp[pos] = j;
            dfs(j, n, k, pos+1, tmp, ans);
        }
    }

    static List<List<Integer>> func(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] tmp = new int[k];
        for (int i = 1; i <= n; i++) {
            tmp[0] = i;
            dfs(i, n, k, 1, tmp, ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 1; // 4; //
        int k = 1; // 2; //
        List<List<Integer>> ans = func(n, k);
        System.out.println(ans);
    }
}
