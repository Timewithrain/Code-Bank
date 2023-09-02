package my.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/** 56. 合并区间 */
public class MergeIntervals {

    static int[][] func(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int preS = intervals[0][0];
        int preE = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= preE) {
                preE = Math.max(preE, intervals[i][1]);
            } else {
                list.add(new int[]{preS, preE});
                preS = intervals[i][0];
                preE = intervals[i][1];
            }
        }
        list.add(new int[]{preS, preE});
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}}; // {{1,4},{4,5}}; // {{1,3},{2,6},{8,10},{15,18}}; //
        int[][] ans = func(intervals);
        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
