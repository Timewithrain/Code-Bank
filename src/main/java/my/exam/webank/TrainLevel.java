package my.exam.webank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 3. 练级
 * 开副本练级，有n个英雄，其等级分别为level[i]，规定练级时选取两个英雄对练
 * 若两个英雄等级相同，则练完后没有经验加成，二者等级不变
 * 若两个英雄等级不同，则练完后等级较高者获得全部经验，高等级者提升1级，低等级者等级不变
 * 需要至少1个英雄等级超过2147483647，才算副本练级通过，请问至少有多少个英雄能够达到通过的标准？
 * 输入：
 * 5
 * 1 2 3 1 2
 * 输出：
 * 3
 * 通过：100%
 */
public class TrainLevel {

    static long func(int[] level, int n) {
        long ans = 0;
        long maxLevel = 0;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            if (level[i] >= 2147483647) {
                cnt += 1;
            } else if (level[i] > maxLevel) {
                maxLevel = level[i];
            }
        }
        if (maxLevel!=0){
            ans = cnt + maxLevel;
        }
        return ans;
    }

    /** 通过18% */
    static int func2(int[] level, int n) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int lel = level[i];
            map.put(lel, map.getOrDefault(lel, 0) + 1);
        }
        int count = 0;
        for (int lel : map.keySet()) {
            int curCnt = map.get(lel);
            int nexLel = lel+ 1;
            if (!map.containsKey(nexLel) || map.get(nexLel) < curCnt) {
                ans += curCnt;
            }

        }
        return ans;
    }

    /** 100% */
    static long func3(int[] level, int n) {
        long ans = 0;
        int min = level[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, level[i]);
        }
        for (int i = 0; i < n; i++) {
            if (level[i] > min) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = in.nextInt();
        }
        long ans = func(level, n);
        System.out.println(ans);
    }
}
