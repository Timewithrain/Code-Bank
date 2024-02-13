package my.leet;

import my.leet.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/** 145. 二叉树的后序遍历 */
public class BinaryTreePostorderTraversal {

    /** 非递归实现 双栈+反转先序 */
    static List<Integer> func(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> s1 = new LinkedList<>();
        LinkedList<TreeNode> s2 = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !s1.isEmpty()) {
            while (cur != null) {
                s2.push(cur);
                s1.push(cur);
                cur = cur.right;
            }
            while (cur == null && !s1.isEmpty()) {
                cur = s1.pop().left;
            }
        }
        while (!s2.isEmpty()) ans.add(s2.pop().val);
        return ans;
    }

    public static void main(String[] args) {
        int cnt = 0;
        for (int i = 0; i <= 9999; i++) {
            int num = i;
            while (num>0) {
                if (num % 10 == 7) cnt++;
                num /= 10;
            }
        }
        System.out.println(cnt);
    }
}
