package my.leet;

import java.util.*;

/** 207. 课程表 */
public class CourseSchedule {

    static boolean hasCircle(int course, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> set, boolean ans) {
        if (!map.containsKey(course)) return false;
        if (set.contains(course)) return true;
        else set.add(course);
        ArrayList<Integer> preC = map.get(course);
        for (Integer pC : preC) {
            ans = ans || hasCircle(pC, map, set, ans);
            if (ans) break;
        }
        set.remove(course);
        return ans;
    }

    /** dfs 超时 */
    static boolean func(int numCourses, int[][] prerequisites) {
        int l = prerequisites.length;
        int cnt = numCourses;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < l; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasCircle(i, map, set, false)) {
                cnt--;
                break;
            }
        }
        return cnt==numCourses;
    }

    static boolean hasCircle2(int course, int[] allCourse, HashMap<Integer, ArrayList<Integer>> map, LinkedList<Integer> stack, boolean ans) {
        if (!map.containsKey(course)) return false;
        int idx = stack.indexOf(course);
        if (idx != -1) {
            Iterator<Integer> iterator = stack.listIterator(idx);
            while (iterator.hasNext()) {
                allCourse[iterator.next()] = 1;
            }
            return true;
        } else {
            stack.push(course);
        }
        ArrayList<Integer> preC = map.get(course);
        for (Integer pC : preC) {
            ans = ans || hasCircle2(pC, allCourse, map, stack, ans);
            if (ans) break;
        }
        stack.pop();
        return ans;
    }

    /** dfs优化 超时 */
    static boolean func2(int numCourses, int[][] prerequisites) {
        int l = prerequisites.length;
        int cnt = numCourses;
        int[] course = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (course[i]==1 || hasCircle2(i, course, map, stack, false)) {
                cnt--;
                break;
            }
        }
        return cnt==numCourses;
    }

    /** dfs 标准解法 */
    static boolean dfs(int c, int[] allCourse, ArrayList<ArrayList<Integer>> graph, boolean ans) {
        allCourse[c] = 1;
        for (int preC : graph.get(c)) {
            if (allCourse[preC] == 0) {
                ans = ans || dfs(preC, allCourse, graph, ans);
            } else if (allCourse[preC] == 1) {
                return true;
            }
            if (ans) return ans;
        }
        allCourse[c] = 2;
        return ans;
    }

    static boolean func3(int numCourses, int[][] prerequisites) {
        boolean hasCircle = false;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] allCourse = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (allCourse[i] != 0) continue;
            hasCircle = dfs(i, allCourse, graph, hasCircle);
            if (hasCircle) break;
        }
        return !hasCircle;
    }

    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {{1,0}, {0,1}};
        boolean ans = func3(numCourses, prerequisites);
        System.out.println(ans);

    }
}
