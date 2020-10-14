package review_jz.二叉树;

/**
 * @author LiXiwen
 * @date 2020/3/13 15:35
 */
public class p4_重建二叉树 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }
    public static void main(String[] args) {

    }

    TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode tree = new TreeNode(pre[0]);
        int i = 0;
        for (; i < in.length; i++) {
            if (in[i] == pre[0]) {
                break;
            }
        }
        int[] lpr = new int[i];
        int[] lin = new int[i];
        int[] rpr = new int[pre.length - 1 - i];
        int[] rin = new int[pre.length - 1 - i];
        for (int j = 0; j < i; j++) {
            lpr[j] = pre[j+1];
            lin[j] = in[j];
        }
        // 必须要是j = i + 1,不能在
        for (int j = i + 1; j < in.length; j++) {
            rpr[j - i - 1] = pre[j];
            rin[j - i - 1] = in[j];
        }
        tree.left = reConstructBinaryTree(lpr, lin);
        tree.right = reConstructBinaryTree(rpr, rin);
        return tree;
    }

    TreeNode reConstructBinaryTree1(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode tree = new TreeNode(pre[0]);

        int i = 0;
        for (; i < in.length; i++) {
            if (in[i] == pre[0]) {
                break;
            }
        }

        int[] lpre = new int[i];
        int[] lin = new int[i];
        int [] rpre = new int[in.length - i - 1];
        int[] rin = new int[in.length - i - 1];

        for (int j = 0; j < i; j++) {
            lpre[j] = pre[j];
            lin[j] = in[j];
        }

        for (int j = i + 1; j < in.length; j++) {
            rpre[j - i - 1] = pre[j];
            rin[j - i - 1] = in[j];
        }

        tree.left = reConstructBinaryTree1(lpre, lin);
        tree.right = reConstructBinaryTree1(rpre, rin);

        return tree;

    }

}
