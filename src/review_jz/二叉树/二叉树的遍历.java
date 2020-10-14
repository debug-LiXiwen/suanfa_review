package review_jz.二叉树;

import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/3/13 18:08
 */
public class 二叉树的遍历 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public static void dfs(TreeNode tree) {
        Stack<TreeNode> s = new Stack<>();
        s.push(tree);
        while (!s.isEmpty()) {
            TreeNode node = s.pop();
            System.out.println(node.val);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
    }

    public static void preOrder(TreeNode tree) {
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || tree != null) {
            while (tree != null) {
                System.out.println(tree.val);
                tree = tree.left;
            }
            if (!s.isEmpty()) {
                tree = s.pop();
                tree = tree.right;
            }
        }
    }

    public static void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.right != null) {
                s1.push(node.right);
            }
            if (node.left != null) {
                s1.push(node.left);
            }
        }
        while (!s2.isEmpty()) {
            System.out.println(s2.pop().val);
        }
    }
}
