package my.exam.jingdong;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * 京东2024校招笔试题
 * 1.夹棋子问题
 * 小红和小紫一起下夹子棋，棋盘尺寸为3*3，有黑白两棋子，黑棋子用*表示，白棋子用o表示，空格用.表示，小红执黑，小紫执白
 * 若黑棋的左右或者上下有白棋，则黑棋被夹，反之亦然
 * 若黑棋和白棋都被夹霍都未被夹，则平局输出"draw"，若黑棋被夹，则小紫赢输出"yukari"，若白棋被夹，则小红赢"kou"
 * 输入:
 * 3
 * ...
 * o*o
 * ...
 * o**
 * ooo
 * ..*
 * o*o
 * *o*
 * o*o
 * 输出:
 * draw
 * yukari
 * kou
 */
public class ClipChess {

    static String func(Character[][] board) {
        boolean red = true;
        boolean purple = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('.' == board[i][j]) {
                    continue;
                }
                if ('*' == board[i][j] &&
                        ((i>0 && board[i-1][j]=='o' && i< board.length-1 && board[i+1][j]=='o') ||
                                (j>0 && board[i][j-1]=='o' && j<board.length-1 && board[i][j+1]=='o'))) {
                    red = false;
                }
                if ('o' == board[i][j] &&
                        ((i>0 && board[i-1][j]=='*' && i< board.length-1 && board[i+1][j]=='*') ||
                                (j>0 && board[i][j-1]=='*' && j<board.length-1 && board[i][j+1]=='*'))) {
                    purple = false;
                }
            }
        }
        return red==purple ? "draw" : (red ? "kou" : "yukari");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n = in.nextInt();
        in.nextLine();
        ArrayList<Character[][]> boards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Character[][] board = new Character[3][3];
            for (int j = 0; j < 3; j++) {
                String s = in.next();
                for (int k = 0; k < 3; k++) {
                    board[j][k] = s.charAt(k);
                }
            }
            boards.add(board);
        }
        for (Character[][] board : boards) {
            System.out.println(func(board));
        }
    }
}

