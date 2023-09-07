package my.exam.ctrip;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 小游的矩阵
 * 在输入的字符矩阵中，找出由y、o、u三个字符为顶点的所有直角三角形
 * 输出三角形的个数
 * 通过10%
 */
public class YouMatrix {

    static boolean isMatch(Integer[] y, Integer[] o, Integer[] u) {
        boolean ans = false;
        if ((y[0]==o[0] && u[0]!=o[0] && (u[1]==y[1] || u[1]==o[1])) ||
             (y[0]==u[0] && o[0]!=u[0] && (o[1]==y[1] || o[1]==u[1])) ||
             (o[0]==u[0] && y[0]!=o[0] && (y[1]==o[1] || y[1]==u[1]))) {
            ans = true;
        }
        return ans;
    }

    static int func(ArrayList<Integer[]> Y, ArrayList<Integer[]> O, ArrayList<Integer[]> U) {
        int ans = 0;
        for (int i = 0; i < Y.size(); i++) {
            Integer[] y = Y.get(i);
            for (int j = 0; j < O.size(); j++) {
                Integer[] o = O.get(j);
                for (int k = 0; k < U.size(); k++) {
                    Integer[] u = U.get(k);
                    if (isMatch(y, o, u)) ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();
        char[][] matrix = new char[n][m];
        ArrayList<Integer[]> Y = new ArrayList<>();
        ArrayList<Integer[]> O = new ArrayList<>();
        ArrayList<Integer[]> U = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            for (int j = 0; j < m; j++) {
                Character c = s.charAt(j);
                matrix[i][j] = c;
                if (c=='y') {
                    Y.add(new Integer[]{i, j});
                } else if (c=='o') {
                    O.add(new Integer[]{i, j});
                } else if (c=='u') {
                    U.add(new Integer[]{i, j});
                }
            }
        }
        System.out.println(func(Y, O, U));
    }
}

//2 3
//        you
//        our