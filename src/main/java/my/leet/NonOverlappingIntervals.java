package my.leet;

import java.util.Arrays;

/** 435. 无重叠区间 */
public class NonOverlappingIntervals {

    static int func(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);  // 按照左端点升序排序
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i-1][1]) {
                ans++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i-1][1]);  // 删除右端点大的区间
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}}; // {{1,2},{1,2},{1,2}}; // {{1,2},{2,3}}; //
        System.out.println(func(intervals));
    }
}
