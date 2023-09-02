package my.leet;

import java.util.Arrays;

/** 452. 是用最少数量的箭引爆气球 */
public class MinimumNumberOfArrowsToBurstBalloons {

    /** 标准解法: 直接比较 */
    static int func(int[][] points) {
        int n = points.length;
        if (n==0) return 0;
        int ans = 1;
        int[] cur = points[0];
        for (int i = 1; i < n; i++) {
            if (points[i][0] > cur[1]) {
                ans++;
                cur = points[i];
            } else {
                cur[0] = Math.max(cur[0], points[i][0]);
                cur[1] = Math.min(cur[1], points[i][1]);
            }
        }
        return ans;
    }

    /** O(nlogn) 排序+遍历比较*/
    static int func2(int[][] points) {
        int n = 0;
        Arrays.sort(points, (o1, o2) -> ((long) o1[0] - (long) o2[0]) > 0 ? 1 : -1);  // 避免溢出使用强转做差再判断正负
        for (int i = 1; i < points.length; i++) {
            if (points[i-1][1] >= points[i][0]) {
                n += 1;
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }
        }
        return points.length - n;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}}; // {{10,16},{2,8},{1,6},{7,12}}; // {{1,2},{3,4},{5,6},{7,8}}; // {{1,2},{2,3},{3,4},{4,5}}; //
        System.out.println(func(points));
    }
}
