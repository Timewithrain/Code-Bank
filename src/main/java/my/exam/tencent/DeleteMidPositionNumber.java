package my.exam.tencent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 删除中位数
 * 给定一个长度为n的数组a和n-1长度的数组b
 * b中每个数都不相同，且在[1,n-1]之间
 * 输出输出a的中位数(排序后)
 * 按i属于[1,n-1]的顺序每次删除a[b[i]-1]中的一个数，继续输出删除后的中位数(排序后)直至结束
 * 按顺序输出每次查找的中位数
 * 输入：
 * 5
 * 1 2 3 4 5
 * 1 2 3 4
 * 输出：
 * 3 3 3 3
 */
public class DeleteMidPositionNumber {

    static float[] func(int[] a, int[] ac, int[] b) {
        int l = a.length;
        float[] ans = new float[a.length];
        int[] map = new int[a.length]; // a -> ac
        Arrays.sort(ac);
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < ac.length; i++) {
            list.add(ac[i]);
            for (int j = 0; j < a.length; j++) {
                if (ac[i] == a[j]) {
                    map[j] = i;
                    a[j] = -1;
                    break;
                }
            }
        }
        ans[0] = l%2 == 1 ? ac[l/2] : (ac[l/2] + ac[l/2 - 1]) / 2.0f;
        for (int i = 1; i <= b.length; i++) {
            Integer itm = ac[map[b[i-1]-1]];
            list.remove(itm);
            if (list.size()%2==1) {
                ans[i] = list.get(list.size()/2);
            } else {
                ans[i] = (list.get(list.size()/2) + list.get(list.size()/2-1)) / 2.0f;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        ArrayList<float[]> ans = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n];
            int[] ac = new int[n];
            int[] b = new int[n-1];
            for (int j = 0; j < n; j++) {
                a[j] = in.nextInt();
                ac[j] = a[j];
            }
            for (int j = 0; j < n-1; j++) {
                b[j] = in.nextInt();
            }
            ans.add(func(a, ac, b));
        }
        for (int i = 0; i < t; i++) {
            float[] an = ans.get(i);
            if (an[0]%1. != 0) {
                System.out.printf("%.1f", an[0]);
            } else {
                System.out.printf("%d", (int) an[0]);
            }
            for (int j = 1; j < an.length; j++) {
                if (an[j]%1. != 0) {
                    System.out.printf(" %.1f", an[j]);
                } else {
                    System.out.printf(" %d", (int) an[j]);
                }
            }
            System.out.println();
        }
    }
}
