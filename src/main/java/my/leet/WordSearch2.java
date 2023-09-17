package my.leet;

/** 79. 单词搜索 */
public class WordSearch2 {

    static boolean dfs(char[][] board, int[][] visited, int i, int j, int pos, String word) {
        if (pos == word.length()) return true;
        if (i < 0 || i>=board.length || j < 0 || j>=board[0].length || visited[i][j] == 1) return false;
        visited[i][j] = 1;
        boolean ans = false;
        if (board[i][j] == word.charAt(pos)) {
            ans = ans || dfs(board, visited, i+1, j, pos+1, word);
            ans = ans || dfs(board, visited, i, j+1, pos+1, word);
            ans = ans || dfs(board, visited, i-1, j, pos+1, word);
            ans = ans || dfs(board, visited, i, j-1, pos+1, word);
        }
        visited[i][j] = 0;
        return ans;
    }

    static boolean func(char[][] board, String word) {
        boolean ans = false;
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ans = ans || dfs(board, visited, i, j, 0, word);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "ABCB";
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
//        String word = "SEE";
        char[][] board = {{'b'}, {'a'}, {'b'}, {'b'}, {'a'}};
        String word = "baa";
        boolean ans = func(board, word);
        System.out.println(ans);
    }
}
