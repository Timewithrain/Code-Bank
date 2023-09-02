package my.exam.mihoyo;

import java.util.Scanner;

/**
 * 给定一棵树，包含n个节点，给定一种操作:对树的叶子节点添加新的叶子节点，每一个节点之间路径都为1
 * 求进行任意次操作后，树的全部节点种到根节点路径不超过k的节点的个数的最大值
 * 例如:
 * 输入: n=4,k=2; 树的初始边为: 1-2，1-3，2-4
 * 4 2
 * 1 2
 * 1 3
 * 2 4
 * 输出: 执行一次操作添加节点5至3后，构成3-5边，此时到根节点路径不超过2的节点的个数最大值为5，
 * 5
 */
public class Exam2 {

    static int func(int[] tree, int[] child, int n, int k) {
        int ans = 0;
        int a = 0;
        int b = 0;
        for (int i = 1; i < tree.length; i++) {
            if (child[i]==0) { // 若节点没有子节点，则其待添加节点
                a = i;
                b = ++n;
                if (b>=tree.length) break;
                tree[b] = tree[a] + 1;
            }
        }
        for (int i = 1; i < tree.length; i++) {
            if (tree[i]<=k) ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a = 0;
        int b = 0;
        int[] tree = new int[n*k+1];
        int[] child = new int[n*k+1];
        for (int i = 0; i < n-1; i++) {
            a = in.nextInt();
            b = in.nextInt();
            // 记录树的结构
            if (a==1) {
                tree[b] = 1;
            } else {
                tree[b] = tree[a] + 1;  // 记录从b节点到根节点的路径长度
            }
            // 记录节点是否有子节点
            child[a] = 1;
        }
        int ans = func(tree, child, n, k);
        System.out.println(ans);
    }

}
