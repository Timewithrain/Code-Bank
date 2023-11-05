package my.leet;

import java.util.*;

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

    /** dfs 超时 */
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

    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {{1,0}, {0,1}};
        boolean ans = func(numCourses, prerequisites);
        System.out.println(ans);

    }
}
