package my.leet;

/**
 * 36. 有效的数独
 */
public class ValidSudoku {

    static boolean func(char[][] board) {
        int[] tmp = new int[board.length+1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]!='.')
                    tmp[board[i][j]-'0'] += 1;
            }
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j]>1)
                    return false;
                tmp[j] = 0;
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i]!='.')
                    tmp[board[j][i]-'0'] += 1;
            }
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j]>1)
                    return false;
                tmp[j] = 0;
            }
        }
        for (int i = 1; i < board.length; i+=3) {
            for (int j = 1; j < board.length; j+=3) {
                for (int m = i-1; m <= i+1; m++) {
                    for (int n = j-1; n <= j+1; n++) {
                        if (board[m][n]!='.')
                            tmp[board[m][n]-'0'] += 1;
                    }
                }
                for (int k = 0; k < tmp.length; k++) {
                    if (tmp[k] > 1)
                        return false;
                    tmp[k] = 0;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
//                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board = {{'.','.','.','.','5','.','.','1','.'},
                          {'.','4','.','3','.','.','.','.','.'},
                          {'.','.','.','.','.','3','.','.','1'},
                          {'8','.','.','.','.','.','.','2','.'},
                          {'.','.','2','.','7','.','.','.','.'},
                          {'.','1','5','.','.','.','.','.','.'},
                          {'.','.','.','.','.','2','.','.','.'},
                          {'.','2','.','9','.','.','.','.','.'},
                          {'.','.','4','.','.','.','.','.','.'}};
        boolean ans = func(board);
        System.out.println(ans);
    }
}
