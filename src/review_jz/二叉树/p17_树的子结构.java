package review_jz.二叉树;

/**
 * @author LiXiwen
 * @date 2020/3/13 21:06
 */
public class p17_树的子结构 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {
            this.val = val;
        }
    }

    public static boolean t1(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return t2(root1, root2) || t2(root1.left, root2) || t2(root1.right, root2);
    }

    public static boolean t2(TreeNode root1, TreeNode root2) {
        // 如果同时结束，返回true
        if (root1 == null && root2 == null) {
            return true;
        }
        // 如果要找的树提前结束返回true
        if (root2 == null) {
            return true;
        }
        // 如果原树提前结束，返回false
        if (root1 == null) {
            return false;
        }
        // 子结构写法
        if (root1.val != root2.val) {
            return t2(root1.left, root2) || t2(root1.right, root2);
        }
        // 子树写法
        /*if (root1.val != root2.val) {
            return false;
        }*/
        return t2(root1.left, root2.left) && t2(root1.right, root2.right);
    }

}

/*
输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
子结构不需要完全匹配。
子树需要完全匹配。
 */
