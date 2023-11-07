package my.leet;

import my.leet.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/** 210. 课程表II */
public class CourseScheduleII {

    static boolean canBeDone(int course, int[] allCourse, int[][] searchSet, ArrayList<ArrayList<Integer>> graph, boolean ans) {
        allCourse[course] = 1;
        for (int preC : graph.get(course)) {
            if (allCourse[preC] == 1) return false;
            ans = canBeDone(preC, allCourse, searchSet, graph, ans);
            if (searchSet[preC][1] >= searchSet[course][1]) {  // 记录最大依赖深度
                searchSet[course][0] = searchSet[preC][0];
                searchSet[course][1] = searchSet[preC][1] + 1;
            }
            if (!ans) return ans;
        }
        allCourse[course] = 2;
        return ans;
    }

    static int[] func(int numCourses, int[][] prerequisites) {
        boolean ans = true;
        int[] allCourse = new int[numCourses];
        int[][] searchSet = new int[numCourses][];  // 并查集，searchSet[i][0]代表第i个课程依赖的根课程(依赖深度最大)，searchSet[i][1]代表最大的依赖深度
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {  // 初始化依赖图graph和并查集searchSet
            graph.add(new ArrayList<>());
            searchSet[i] = new int[]{i, 1};
        }
        for (int i = 0; i < prerequisites.length; i++) {  // 构造依赖图
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses && ans; i++) {  // 根据依赖图, 查询全部课程的依赖最深课程和最大依赖深度,并判断是否可以学完课程
            if (allCourse[i]==0) {
                ans = canBeDone(i, allCourse, searchSet, graph, ans);
            }
        }
        if (!ans) return new int[0];
        int cnt = 0;
        int[] ansList = new int[numCourses];
        ArrayList<int[]> list = new ArrayList<>();  // 按照课程依赖深度对课程排序
        for (int i = 0; i < searchSet.length; i++) {
            list.add(new int[]{i, searchSet[i][1]});
        }
        list.sort((o1, o2) -> o1[1] - o2[1]);
        for (int i = 0; i < list.size(); i++) {
            ansList[cnt++] = list.get(i)[0];
        }
        return ansList;
    }

    public static void main(String[] args) {
        int numCourses = 4; // 3; // 2; // 2; // 1; //
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}}; // {{2,0}, {2,1}}; // {{1,0}, {0,1}}; // {{0,1}}; // {}; //
        int[] ans = func(numCourses, prerequisites);
        ArrayUtils.printArray(ans);
    }
}
