package my.leet;

import java.util.LinkedList;

/** 1926. 迷宫中离入口最近的出口 */
public class NearestExitFromEntranceInMaze {

    static boolean isExit(char[][] maze, int[][] visited, int x, int y) {
        boolean flag = false;
        if (maze[x][y]=='+') return flag;
        int w = maze.length - 1;
        int h = maze[0].length - 1;
        if (x == 0 || y == 0 || x == w || y == h) flag = true;
        return flag;
    }

    static int func(char[][] maze, int[] entrance) {
        int ans = -1;
        int tmp = 0;
        int m = maze.length - 1;
        int n = maze[0].length - 1;
        int[][] visited = new int[m+1][n+1];
        visited[entrance[0]][entrance[1]] = 1;
        LinkedList<int[]> queue = new LinkedList<>();
        int[] tag = new int[]{-1, -1};
        queue.add(entrance);
        queue.add(tag);
        while (queue.size() > 1) {
            int[] pos = queue.poll();
            if (pos == tag) {
                tmp += 1;
                queue.add(pos);
            } else {
                int x = pos[0];
                int y = pos[1];
                if (!(x== entrance[0] && y==entrance[1]) && isExit(maze, visited, x, y)) {
                    ans = tmp;
                    break;
                }
                if (x>0 && maze[x-1][y]=='.' && visited[x-1][y]==0) {visited[x-1][y] = 1; queue.add(new int[]{x-1, y});}
                if (x<m && maze[x+1][y]=='.' && visited[x+1][y]==0) {visited[x+1][y] = 1; queue.add(new int[]{x+1, y});}
                if (y>0 && maze[x][y-1]=='.' && visited[x][y-1]==0) {visited[x][y-1] = 1; queue.add(new int[]{x, y-1});}
                if (y<n && maze[x][y+1]=='.' && visited[x][y+1]==0) {visited[x][y+1] = 1; queue.add(new int[]{x, y+1});}
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
//        char[][] maze = {{'+','.','+','+','+','+','+'},
//            {'+','.','+','.','.','.','+'},
//            {'+','.','+','.','+','.','+'},
//            {'+','.','.','.','+','.','+'},
//            {'+','+','+','+','+','+','.'}};
        int[] entrance = {1, 0}; // {0, 1}; //
        int ans = func(maze, entrance);
        System.out.println(ans);
    }
}


