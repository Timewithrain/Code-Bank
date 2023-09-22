package my.leet;

/** 547. 省份数量 */
public class NumberOfProvinces {

    /** 深搜，标注联通的城市 */
    static void  dfs(int[][] connected, int[][] visited, int i) {
        for (int j = 0; j < connected[i].length; j++) {
            if (connected[i][j] == 1 && visited[i][j] == 0) {
                visited[i][j] = 1;
                visited[j][i] = 1;
                dfs(connected, visited, j);
            }
        }
    }

    static int func(int[][] isConnected) {
        int m = isConnected.length;
        int n = isConnected[0].length;
        int[][] visited = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j]==1 && visited[i][j] == 0) {  // 遇见新的未联通的城市ans++
                    dfs(isConnected, visited, i);  // 标注所有联通城市
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] connected = {{1,0,0},{0,1,0},{0,0,1}}; // {{1,1,0},{1,1,0},{0,0,1}}; //
        int ans = func(connected);
        System.out.println(ans);
    }
}
