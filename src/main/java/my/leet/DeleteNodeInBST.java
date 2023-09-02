package my.leet;

import my.leet.utils.BinaryTree;
import my.leet.utils.TreeNode;

/** 450. 删除二叉搜索树中的节点 */
public class DeleteNodeInBST {

    static TreeNode dfs(TreeNode pre, TreeNode cur, int key) {
        if (cur==null) return null;
        if (cur.val == key) {
            return pre;
        } else {
            if (cur.val > key) {
                return dfs(cur, cur.left, key);
            } else {
                return dfs(cur, cur.right, key);
            }
        }
    }

    static TreeNode func(TreeNode root, int key) {
        if (root==null) return null;
        TreeNode pre = dfs(null, root, key);
        if (root.val==key) {  // 根节点为目标删除节点
            if (root.left!=null && root.right!=null) {
                pre = root;  // 将pre置为root，后续删除操作与普通节点删除操作一致
            } else if (root.left==null) {
                return root.right;
            } else {
                return root.left;
            }
        }
        if (pre==null) return root;
        TreeNode cur = pre.val==key ? pre : (pre.val>key ? pre.left : pre.right);
        if (cur.left!=null && cur.right!=null) {
            TreeNode p = cur;
            TreeNode q = cur.right;
            while (q.left!=null) {  // 找到右子树上的最小节点作为交换节点
                p = q;
                q = q.left;
            }
            cur.val = q.val;
            if (p!=cur)
                p.left = q.right;
            else
                cur.right = q.right;
        } else {
            if (cur.val < pre.val) {
                pre.left = cur.left!=null ? cur.left : cur.right;
            } else {
                pre.right = cur.left!=null ? cur.left : cur.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] nums = {5,3,6,2,4,null,7};
        int key = 5;
        TreeNode root = BinaryTree.createBinaryTree(nums);
        TreeNode ans = func(root, key);
        BinaryTree.printBinaryTree(ans);
    }
}
