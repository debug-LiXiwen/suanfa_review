package review_jz.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiXiwen
 * @date 2020/1/25 23:22
 */
public class p38_二叉树的深度 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public int TreeDepth1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = 0;
        TreeNode node = null;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            //一次处理一层的数据
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
/*
输入一棵二叉树，求该树的深度。
从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */