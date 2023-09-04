package my.exam.meituan2;

import java.util.Scanner;

/**
 * 小美的子序列
 * 给定一个n行m列的矩阵，矩阵中的元素为小写字母，给定一个字符s
 * 从n行中每行抽出一个字符，组成一个字符串，问能否从这些字符串中找到一个子序列等于s
 * 通过100%
 */
public class MeiSubsequence {

    static boolean func(char[][] matrix, String s) {
        if (matrix.length < s.length()) return false;
        int l = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == s.charAt(l)) {
                    l++;
                    break;
                }
            }
            if (l==s.length()) break;
        }
        return l==s.length();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] matrix = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = s.charAt(j);
            }
        }
        if (func(matrix, "meituan")) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
