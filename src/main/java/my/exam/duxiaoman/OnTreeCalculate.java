package my.exam.duxiaoman;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 2. 上树运算
 * 设定一棵计算树，若树有子节点，则其必有两个子节点，若其无子节点则其值必为1
 * 树的节点包含两种颜色，红色代表对其两个子节点做加法，蓝色代表对其两个子节点做乘法
 * 输入描述:
 * 第一行一个n，代表树节点个数
 * 第二行n-1个数，代表每个节点的父节点
 * 第三行n个数，代表每个节点的颜色，1代表红色，2代表蓝色
 * 输出描述:
 * 一个数，代表计算结果
 * 通过 90%
 * 用例
 * 输入:
 * 3
 * 1 1
 * 1 1 1
 * 输出:
 * 2
 */
public class OnTreeCalculate {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] tree = new int[n];
        int[] c = new int[n];
        long[] ans = new long[n];
        for (int i = 1; i < n; i++) {
            tree[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
            ans[i] = 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();  // 记录父节点和子节点
        int i = n-1;
        while (i>0) {
            if (!map.containsKey(tree[i])) {  // 仅找到一个子节点，将其放入map中
                map.put(tree[i], i);  // 父节点在tree中的位置，子节点在tree中的位置
            } else {
                int j = map.get(tree[i]);  // 找到两个子节点，从map中拿出另一个子节点
                if (c[tree[i]-1]==1) {  // 根据父节点的颜色，对两个子节点进行运算，将结果存储与ans中
                    ans[tree[i]-1] = ans[j] + ans[i];
                } else if (c[tree[i]-1]==2)  {
                    ans[tree[i]-1] = ans[j] * ans[i];
                }
            }
            i--;
        }
        System.out.println(ans[0]%100000007);
    }
}
