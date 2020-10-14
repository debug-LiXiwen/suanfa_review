package review_jz.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LiXiwen
 * @date 2020/3/18 10:31
 */
public class p60_把二叉树打印成多行 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                node = q.remove();
                list.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
