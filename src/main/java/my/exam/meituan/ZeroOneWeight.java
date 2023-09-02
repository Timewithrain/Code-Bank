package my.exam.meituan;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 1.小美的01权值
 * 给定一个01字符串，定义01串的权值为：使串内相邻两个值不同的最小取反次数，如0101的权值为0，0011的权值为2，110的权值为1
 * 小美想知道，对于给定的01串，所有非空子串的权值之和是多少
 * 通过56%，超时，动态规划没写出来
 */
public class ZeroOneWeight {

    static int weight(String s, int start, int end) {
        int n = 0;
        int m = 0;
        for (int i = start; i < end; i++) {
            if (s.charAt(i) == (i%2==0?'1':'0')) {
                n++;
            }
            if (s.charAt(i) == (i%2==0?'0':'1')) {
                m++;
            }
        }
        return Math.min(n, m);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int ans = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                if (i==j) continue;
                String sub = s.substring(i, j+1);
                ans = weight(sub, i, j);
            }
        }
        System.out.println(ans);
    }
}
