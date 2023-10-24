package my.exam.ctrip;

import java.util.Scanner;

/**
 * 1. 字符串操作
 * 给定两种操作：
 * 删除子串 1 x y 代表删除第x个到第y个字符
 * 插入子串 2 x str 代表在第x个字符后面插入字符串str
 * 输入字符串s和操作次数q，输出最终字符串
 * 输入：
 * abcde
 * 3
 * 1 2 4
 * 2 1 rca
 * 2 5 a
 * 输出：
 * arcaea
 * 通过：100%
 */
public class SecondYouStringOperation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
            int opt = in.nextInt();
            int x = in.nextInt();
            String y = in.next();
            if (opt == 1) {
                sb.delete(x-1, Integer.parseInt(y));
            } else if (opt == 2) {
                sb.insert(x, y);
            }
        }
        System.out.println(sb.toString());
    }
}

/*
abcde
3
1 2 4
2 1 rca
2 5 a
输出：
arcaea
 */
