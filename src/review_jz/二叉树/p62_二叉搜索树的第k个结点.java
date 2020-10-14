package review_jz.二叉树;

/**
 * @author LiXiwen
 * @date 2020/3/18 10:44
 */
public class p62_二叉搜索树的第k个结点 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    int index = 0;
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k == 0) {
            return null;
        }

        TreeNode node = KthNode(root.left, k);
        if (node != null) {
            return node;
        }
        index++;
        if (index == k) {
            return root;
        }
        node = KthNode(root.right, k);
        if (node != null) {
            return node;
        }
        return null;
    }


}
