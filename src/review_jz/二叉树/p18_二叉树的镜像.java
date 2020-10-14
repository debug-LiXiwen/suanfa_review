package review_jz.二叉树;

import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/3/13 21:22
 */
public class p18_二叉树的镜像 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public void Mirror1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            TreeNode t = node.left;
            node.left = node.right;
            node.right = t;
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);
    }

}

/*
操作给定的二叉树，将其变换为源二叉树的镜像。
输入描述:
二叉树的镜像定义：源二叉树
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9  11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11  9 7   5

    每两个进行翻转就好了
        	 8
    	   /  \
    	  10   6
    	 / \  / \
    	5  7 9  11

 */
