package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.*;

/** 399. 除法求值 */
public class EvaluateDivision {

    static double[] calculate(List<List<String>> equations, String A, String B, double[] values, HashMap<String, List<Integer>> mul,
                            HashMap<String, List<Integer>> div, HashSet<String> set, double[] ans) {
        if (A.equals(B) && (mul.containsKey(A) || div.containsKey(A))) {  // 当A和B相等时，除以自身结果为1，直接设标志位ans[0]为2返回
            ans[0] = 2;
            return ans;
        }
        if (mul.containsKey(A)) {  // 乘法方向深度优先搜索结果
            List<Integer> idx = mul.get(A);
            for (Integer i : idx) {
                List<String> equ = equations.get(i);
                String t = equ.get(1);
                if (t.equals(B)) {  // 找到目标结果
                    ans[1] *= values[i];
                    ans[0] = 2;  // 设置标志位为2，返回
                    return ans;
                } else if (!set.contains(t)) {  // set用于记录搜索过的符号，避免重复
                    set.add(t);
                    ans[1] *= values[i];
                    ans = calculate(equations, t, B, values, mul, div, set, ans);
                    if (ans[0]<1) ans[1] /= values[i];  // 若标志位小于1说明未找到结果，当前路径失配，回滚当前运算后继续搜索
                    set.remove(t);
                }
                if (ans[0]>1) return ans;
            }
        }
        if (div.containsKey(A)) {  // 除法方向深度优先搜索结果
            List<Integer> idx = div.get(A);
            for (Integer i : idx) {
                List<String> equ = equations.get(i);
                String t = equ.get(0);
                if (t.equals(B)) {  // 找到目标结果
                    ans[1] *= 1 / values[i];
                    ans[0] = 2;
                    return ans;
                } else if (!set.contains(t)) {
                    set.add(t);
                    ans[1] *= 1 / values[i];
                    ans = calculate(equations, t, B, values, mul, div, set, ans);
                    if (ans[0]<1) ans[1] /= 1 / values[i];
                    set.remove(t);
                }
                if (ans[0]>1) return ans;
            }
        }
        return ans;
    }

    static double[] func(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Integer>> mul = new HashMap<>();  // 记录相乘方向的A以及对应的B在equations中的下标，用于加速搜索
        HashMap<String, List<Integer>> div = new HashMap<>();  // 记录除法方向的A以及对应的B在equations中的下标
        for (int i = 0; i < equations.size(); i++) {  // 构造mul和div
            List<String> equ = equations.get(i);
            String A = equ.get(0);
            String B = equ.get(1);
            if (mul.containsKey(A)) {
                mul.get(A).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mul.put(A, list);
            }
            if (div.containsKey(B)) {
                div.get(B).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                div.put(B, list);
            }
        }
        double[] ans = new double[queries.size()];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {  // 深度搜索
            List<String> query = queries.get(i);
            String A = query.get(0);
            String B = query.get(1);
            set.add(A);
            double[] a = calculate(equations, A, B, values, mul, div, set, new double[]{0, 1});
            set.remove(A);
            ans[i] = a[0]>1 ? a[1] : -1;  // a[0]为标志位，其值为2时运算有结果，结果保存于a[1]否则运算无结果ans赋值为-1
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] ans = func(equations, values, queries);
        ArrayUtils.printArray(ans);
    }
}
