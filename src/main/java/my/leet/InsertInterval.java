package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.ArrayList;

/** 57. 插入区间 */
public class InsertInterval {

    static int[][] func(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int l = intervals.length;
        int i = 0;
        for (; i < l && intervals[i][1] < newInterval[0]; i++) {  // 处理交叠前的部分
            ans.add(intervals[i]);
        }
        for (; i < l && intervals[i][0] <= newInterval[1]; i++) {  // 处理交叠部分
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        ans.add(newInterval);
        for (; i < l && intervals[i][0] > newInterval[1]; i++) {  // 处理交叠后的部分
            ans.add(intervals[i]);
        }
        int[][] ansArr = new int[ans.size()][];
        for (int j = 0; j < ans.size(); j++) {
            ansArr[j] = ans.get(j);
        }
        return ansArr;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3}, {6,9}}; // {{1,2},{3,5},{6,7},{8,10},{12,16}}; // {{1,5}}; // {}; // {{0,5},{9,12}}; // {{1,2},{3,5},{6,7},{8,10},{12,16}}; //
        int[] newInterval = {2,5}; // {4,8}; // {5, 7}; // {2,7}; // {7,16}; // {2,3}; //
        int[][] ans = func(intervals, newInterval);
        ArrayUtils.printArray(ans);
    }
}
