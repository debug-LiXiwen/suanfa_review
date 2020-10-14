package review_jz.二叉树;

/**
 * @author LiXiwen
 * @date 2020/1/25 23:32
 */
public class p39_平衡二叉树 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 中序遍历是第一个递增的序列
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        return judge(root);
    }

    private boolean judge(TreeNode root) {
        if (root != null && root.left == null && root.right == null) {
            return true;
        }
        if (root.left.val > root.val || root.val > root.right.val) {
            return false;
        }
        return judge(root.left) && judge(root.right);
    }


//后续遍历时，遍历到一个节点，其左右子树已经遍历  依次自底向上判断，每个节点只需要遍历一次

    private boolean isBalanced=true;
    public boolean IsBalanced_Solution1(TreeNode root) {
        getDepth(root);
        return isBalanced;
    }
    public int getDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l = getDepth(root.left);
        int r = getDepth(root.right);
        if (Math.abs(l - r) > 1) {
            isBalanced = false;
        }
        return Math.max(l, r) + 1;
    }

}
/*
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

平衡二叉树定义(AVL)：它或者是一颗空树，
或者具有以下性质的二叉排序树：它的左子树和右子树的深度之差(平衡因子)的绝对值不超过1，
且它的左子树和右子树都是一颗平衡二叉树。
 条件一：它必须是二叉查找树。
条件二：每个节点的左子树和右子树的高度差至多为1。
 */
