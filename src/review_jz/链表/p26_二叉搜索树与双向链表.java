package review_jz.链表;

import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/1/22 16:08
 */
public class p26_二叉搜索树与双向链表 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode Convert(TreeNode tree) {
        if (tree == null) {
            return null;
        }
        if (tree != null && tree.left == null && tree.right == null) {
            return tree;
        }
        convertSub(tree);
        return head;
    }

    void convertSub(TreeNode root) {
        if (root == null) {
            return;
        }
        convertSub(root.left);
        if (pre == null) {
            pre = root;
            head = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        convertSub(root.right);
    }

}

/*
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
      9
    /   \
  5      13
 / \    /  \
3   7  11  15

转换成双向链表
3=5=7=9=11=13=15。
 */
