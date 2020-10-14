package review_jz.二叉树;

import java.util.ArrayList;

/**
 * @author LiXiwen
 * @date 2020/1/21 22:11
 */
public class p24_二叉树中和为某一值的路径 {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    /**
     * 典型的深度遍历，先序遍历
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return res;
    }

}
