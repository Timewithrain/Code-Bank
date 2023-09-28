package my.exam.netease2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HongPathCover {

    static int distance(List<List<Integer>> graph, int i, int j) {
        int lca = getLCA(graph, new int[]{i, j});
        return depth(graph, i) + depth(graph, j) - 2 * depth(graph, lca);
    }

    static int depth(List<List<Integer>> graph, int i) {
        int depth = 0;
        while (i!=0) {
            i = graph.get(i).get(0);
            depth++;
        }
        return depth;
    }

    static int ancestor(int[] parent, int i, int cnt) {
        while (cnt>0) {
            i = parent[i];
            cnt--;
        }
        return i;
    }

    static void dfs(List<List<Integer>> graph, int i, int[] parent, int[] depth, boolean[] visited) {
        if (visited[i]) return;
        visited[i] = true;
        for (int j = 0; j < graph.get(i).size(); j++) {
            int v = graph.get(i).get(j);
            if (!visited[v]) {
                parent[v] = i;
                depth[v] = depth[i] + 1;
                dfs(graph, v, parent, depth, visited);
            }
        }
        visited[i] = false;
    }

    static int getLCA(List<List<Integer>> graph, int[] nodes) {
        int n = graph.size();
        int[] parent = new int[n];
        int[] depth = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            depth[i] = 0;
        }

        dfs(graph, nodes[0], parent, depth, visited);


        int lca = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            if (depth[nodes[i]] < depth[lca]) {
                lca = nodes[i];
            }
        }

        System.out.println("in");
        while (true) {
            boolean isMatch = true;
            for (int i = 0; i < nodes.length; i++) {
                if (nodes[i] == lca) continue;
                int preLCA = ancestor(parent, nodes[i], depth[lca] - 1);
                if (preLCA != lca) {
                    lca = preLCA;
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) break;
        }
        System.out.println("out");
        return lca;
    }

    static int func(List<List<Integer>> graph, int[] nodes) {
        int lca = getLCA(graph, nodes);

        int disSum = 0;
        for (int i = 0; i < nodes.length; i++) {
            disSum += distance(graph, nodes[i], lca);
        }
        return disSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] ans = new int[q];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n-1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for (int i = 0; i < q; i++) {
            int k = in.nextInt();
            int[] nodes = new int[k];
            for (int j = 0; j < k; j++) {
                nodes[j] = in.nextInt();
            }

            ans[i] = func(graph, nodes);
        }
        for (int i = 0; i < q; i++) {
            System.out.println(ans[i]);
        }
    }
}
