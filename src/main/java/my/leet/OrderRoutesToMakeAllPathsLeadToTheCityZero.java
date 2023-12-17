package my.leet;

import java.util.*;

/** 1466. 重新规划路线 */
public class OrderRoutesToMakeAllPathsLeadToTheCityZero {

    /** 链表存储connections，超时 */
    static int func(int n, int[][] connections) {
        int ans = 0;
        int l = connections.length;
        int[] visited = new int[n];
        HashSet<Integer> set = new HashSet<>();
        LinkedList<int[]> conn = new LinkedList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            conn.add(connections[i]);
        }
        set.add(0);
        visited[0] = 1;
        n--;
        while (n > 0) {
            Iterator<int[]> iter = conn.iterator();
            while (iter.hasNext()) {
                int[] cur = iter.next();
                int a = cur[0], b = cur[1];
                if (set.contains(b)) {
                    if (visited[a] == 0) {
                        visited[a] = 1;
                        n--;
                    }
                    tmp.add(a);
                    iter.remove();
                } else if (set.contains(a)) {
                    if (visited[b] == 0) {
                        visited[b] = 1;
                        n--;
                    }
                    tmp.add(b);
                    ans++;
                    iter.remove();
                }
            }
            set.clear();
            set.addAll(tmp);
            tmp.clear();
        }
        return ans;
    }

    static boolean isReverse(int cur, int target, HashMap<Integer, HashSet<Integer>> conn) {
        HashSet<Integer> set = conn.get(cur);
        if (set != null && set.contains(target)) return false;
        return true;
    }

    static int dfs(int cur, int pre, HashMap<Integer, HashSet<Integer>> conn, HashMap<Integer, ArrayList<Integer>> to) {
        int ans = 0;
        ArrayList<Integer> targets = to.get(cur);
        for (Integer target : targets) {
            if (target == pre) continue;
            if (!isReverse(cur, target, conn)) ans++;
            ans += dfs(target, cur, conn, to);
        }
        return ans;
    }

    static int func2(int n, int[][] connections) {
        int ans = 0;
        HashMap<Integer, HashSet<Integer>> conn = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> to = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            int a = connections[i][0], b = connections[i][1];
            ArrayList<Integer> at = to.getOrDefault(a, new ArrayList<>());
            at.add(b);
            to.put(a, at);
            ArrayList<Integer> bt = to.getOrDefault(b, new ArrayList<>());
            bt.add(a);
            to.put(b, bt);
            HashSet<Integer> set = conn.getOrDefault(a, new HashSet<>());
            set.add(b);
            conn.put(a, set);
        }
        ans = dfs(0, -1, conn, to);

        return ans;
    }

    public static void main(String[] args) {
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        int n = 6;
        int ans = func(n, connections);
        System.out.println(ans);
        ans = func2(n, connections);
        System.out.println(ans);

    }
}
