package my.nowcoder;

import my.leet.utils.TreeNode;

/**
 * JZ 26. 树的子结构
 * 判断root2是否为root1的子结构
 */
public class HasSubTree {

    static boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2==null) return true;
        if (root1!=null && root2!=null && root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    /**
     * 递归求解，首先判断当前值是否相等，若相等则调用isSubTree判断两树是否结构一致；否则继续遍历root1
     * 注意：判断子树结构一致时，必须保证从root2的根节点开始遍历，因此仅在isSubTree中遍历root2，主方法仅遍历root1
     */
    static boolean func(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2==null) return false;
        return isSubTree(root1, root2) || func(root1.left, root2) || func(root1.right, root2);
    }

    public static void main(String[] args) {

    }
}
