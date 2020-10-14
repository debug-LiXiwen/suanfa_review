package review_jz.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/3/16 9:54
 */
public class leetcode_111_二叉树的最小深度 {
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }


    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.remove();
                if (node.right == null && node.left == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            depth++;
        }
        return -1;
    }


    @SuppressWarnings("Duplicates")
    public int depthOrderTraversal(TreeNode root){
        if (root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int depth = 1;
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left == null && node.right == null) {
                return depth;
            }
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            depth++;
        }
        return -1;
    }


}
