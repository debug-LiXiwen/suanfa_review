package review_jz.二叉树;

/**
 * @author LiXiwen
 * @date 2020/1/27 15:57
 */
public class p57_二叉树的下一个结点 {

    private static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }
        // 有右子树
        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
        // 无右子树
        while (node.next != null) {
            if (node == node.next.left) {
                return node.next;
            }
            node = node.next;
        }
        return null;
    }
}


/*
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */