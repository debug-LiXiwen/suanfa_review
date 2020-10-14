/**
 * lxw.com. Inc.
 * Copyright (c) 2017-2020 All Rights Reserved.
 */
package review_jz.二叉树;

/**
 * @author xichen.lxw
 * @version $Id: leetcode_124_二叉树中的最大路径和.java, v 0.1 2020-09-19 23:39 xichen.lxw Exp $$
 */
public class leetcode_124_二叉树中的最大路径和 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = dfs(root.left);
        int r = dfs(root.right);
        int t = Math.max(l, r);
        if (t > 0) {
            t += root.val;
        } else {
            t = root.val;
        }

        return t;

    }


}
