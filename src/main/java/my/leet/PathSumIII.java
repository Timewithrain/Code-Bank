package my.leet;

import my.leet.utils.TreeNode;

import java.util.ArrayList;

/** 437. 路径总和III  */
public class PathSumIII {

    static int retrieve(TreeNode root, int targetSum, ArrayList<Long> cur) {
        if (root == null) return 0;
        int ans = root.val == targetSum ? 1 : 0;
        for (int i = 0; i < cur.size(); i++) {
            cur.set(i, cur.get(i) + root.val);
            if (cur.get(i) == targetSum) ans += 1;
        }
        cur.add((long) root.val);
        ans += retrieve(root.left, targetSum, new ArrayList<>(cur));
        ans += retrieve(root.right, targetSum, new ArrayList<>(cur));
        return ans;
    }

    static int func(TreeNode root, int targetSum) {
        int ans = 0;
        ArrayList<Long> cur = new ArrayList<>();
        ans = retrieve(root, targetSum, cur);
        return ans;
    }

    public static void main(String[] args){

    }
}
