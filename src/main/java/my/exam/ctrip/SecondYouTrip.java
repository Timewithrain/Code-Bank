package my.exam.ctrip;

import java.util.*;

/**
 * 2. 小游的旅行问题
 * 输入n代表n个城市，k代表k种旅行方案，接下来n行，每行两个数a，b；a代表城市a，b代表对城市的期待值
 * 一年中第一次去的城市，期待值能翻倍，求从全部的a个方案中选出k个方案中最大的期待值
 * 输入：
 * 4 3
 * 1 5
 * 1 6
 * 1 7
 * 3 8
 * 输出：
 * 36
 *  通过：26% 猜测为返回值溢出，应该为long类型
 */
public class SecondYouTrip {

    static long func(int[][] ab, int k) {
        long ans = 0;
        int l = ab.length;
        Arrays.sort(ab, (o1, o2) -> o2[1] - o1[1]);
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            if (set.contains(ab[i][0])) {
                continue;
            } else {
                set.add(ab[i][0]);
                ab[i][1] *= 2;
            }
        }
        Arrays.sort(ab, (o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < k; i++) {
            ans += ab[i][1];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] ab = new int[n][2];
        for (int i = 0; i < n; i++) {
            ab[i][0] = in.nextInt();
            ab[i][1] = in.nextInt();
        }
        long ans = func(ab, k);
        System.out.println(ans);
    }
}

/*
4 3
1 5
1 6
1 7
3 8
 */