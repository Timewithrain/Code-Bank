package my.exam.netease2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StringSimilar {

    static boolean same(int[] a, int[] b) {
        boolean ans = true;
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) {
                ans = false;
                break;
            }
        }
        return ans;
    }

    static long C(int m) {
        if (m < 2) return 0;
        if (m < 3) return 1;
        long top = 1;
        for (int i = 1; i <= m; i++) {
            top *= i;
        }
        long down = 1;
        for (int i = 1; i <= m-2; i++) {
            down *= i;
        }
        return top / (2*down);
    }

    // 计算组合数
    static long C(int m, int n) {
        if (n < m) return 0;
        if (m == n) return 1;
        long[][] dp = new long[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m) ; j++) {
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        return dp[n][m];
    }

    static int countSimilar(ArrayList<String> list) {
        int cnt = 0;
        int n = list.size();
        int[][] vocab = new int[n][26];
        for (int i = 0; i < n; i++) {
            String s = list.get(i);
            for (int j = 0; j < s.length(); j++) {
                vocab[i][s.charAt(j) - 'a']++;
            }
        }
        int[] flag = new int[n];
        for (int i = 0; i < n; i++) {
            if (flag[i] == 1) continue;
            int cur = 0;
            for (int j = i+1; j < n; j++) {
                if (same(vocab[i], vocab[j])) {
                    flag[i] = 1;
                    flag[j] = 1;
                    cur = cur==0 ? 2 : cur+1;
                }
            }
            cnt += C(2, cur);
        }
        return cnt;
    }

    static int func(String[] strs) {
        int l = strs.length;
        int ans = 0;
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            if (map.containsKey(strs[i].length())) {
                map.get(strs[i].length()).add(strs[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(strs[i].length(), list);
            }
        }
        for (Integer i : map.keySet()) {
            ArrayList<String> list = map.get(i);
            ans += countSimilar(list);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.nextLine();
        }
        int ans = func(s);
        System.out.println(ans);
//        System.out.println(C(2, 4));
    }
}
