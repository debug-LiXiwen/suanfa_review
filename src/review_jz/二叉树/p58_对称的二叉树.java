package review_jz.二叉树;

import java.util.LinkedList;

/**
 * @author LiXiwen
 * @date 2020/3/17 23:25
 */
public class p58_对称的二叉树 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetrical(root.left, root.right);
    }

    boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && isSymmetrical(left.left, right.right)
                && isSymmetrical(left.right, right.left);
    }

    boolean test(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while (!q.isEmpty()) {
            TreeNode left = q.remove();
            TreeNode right = q.remove();
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }

}

/*
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */