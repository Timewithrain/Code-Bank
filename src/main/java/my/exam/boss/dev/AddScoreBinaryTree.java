package my.exam.boss.dev;

import java.util.Scanner;

public class AddScoreBinaryTree {

    static class TreeNode {
        public int val;
        public int scr;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {};
        public TreeNode(int val) {this.val = val;}
    }

    static void preorder(TreeNode node) {
        if (node==null) return;
        System.out.printf("%d ", node.val);
        preorder(node.left);
        preorder(node.right);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = in.nextInt();
        }
        int[][] dp = new int[n][n];
        TreeNode[][] roots= new TreeNode[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j + i - 1 < n; j++) {
                int k = i + j - 1;
                if (i==1) {
                    dp[j][k] = score[j];
                    roots[j][k] = new TreeNode(j+1);
                    roots[j][k].scr = score[j];
                } else {
                    dp[j][k] = Integer.MIN_VALUE;
                    for (int l = j; l <= k; l++) {
                        int ls = l > j ? dp[j][l-1] : 1;
                        int rs = l < k ? dp[l+1][k] : 1;
                        int cur = ls * rs + score[l];
                        if (cur > dp[j][k]) {
                            dp[j][k] = cur;
                            TreeNode node = new TreeNode(l+1);
                            node.left = l > j ? roots[j][l-1] : null;
                            node.right = l < k ? roots[l+1][k] : null;
                            node.scr = score[l];
                            roots[j][k] = node;
                        }
                    }
                }
            }
        }
        System.out.printf("%d\n", dp[0][n-1]);
        TreeNode root = roots[0][n-1];
        preorder(root);
    }
}
