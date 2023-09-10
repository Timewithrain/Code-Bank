package my.exam.duxiaoman;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. 查找字符A
 * 第一行输入一个整数n和一个整数k，第二行输入一串由A和B组成长度为n的字符s
 * 令s首位相连，问当找到第k个字符A时，经过了多少次查找
 * 用例1
 * 输入：
 * 3 3
 * AAB
 * 输出:
 * 4
 * 用例2
 * 输入：
 * 3 3
 * BBA
 * 输出:
 * 9
 */
public class SearchCharA {

    /** 计算法，通过55% */
    static long func(String s, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                list.add(i+1);
            }
        }
        int total = list.size();
        long n = 0;
        if (k > total) {
            n = k / total;
            k = k % total;
        }
        long rest = k>0? list.get(k-1) : 0;
        return n * s.length() + rest;
    }

    /** 单纯循环法，超时 通过80% */
    static int func2(String s, int k) {
        int i = 0;
        int cnt = 0;
        while (k>0) {
            if (s.charAt(i) == 'A') {
                k--;
            }
            i = (i+1) % s.length();
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        String s = in.nextLine();
        System.out.println(func(s, k));
    }

}
