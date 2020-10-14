package review_jz.二叉树;

import com.sun.deploy.panel.ITreeNode;

import java.util.*;

/**
 * @author LiXiwen
 * @date 2020/3/17 23:40
 */
public class p59_蛇形顺序打印二叉树 {
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        int depth = 1;
        s1.push(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if ((depth & 1) == 1) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode t = s1.pop();
                    list.add(t.val);
                    if (t.left != null) {
                        s2.push(t.left);
                    }
                    if (t.right != null) {
                        s2.push(t.right);
                    }
                }
                if (list.size() != 0) {
                    res.add(list);
                    depth++;
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!s2.isEmpty()) {
                    TreeNode t = s2.pop();
                    list.add(t.val);
                    if (t.right != null) {
                        s1.push(t.right);
                    }
                    if (t.left != null) {
                        s1.push(t.left);
                    }
                }
                if (list.size() != 0) {
                    res.add(list);
                    depth++;
                }
            }
        }
        return res;
    }

    public ArrayList<ArrayList<Integer>> Print1(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> q = new LinkedList<>();
        int depth = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            depth++;
            ArrayList<Integer> list = new ArrayList<>();
            if ((depth & 1) == 1) {
                Iterator<TreeNode> it = q.iterator();
                while (it.hasNext()) {
                    list.add(it.next().val);
                }
            } else {
                Iterator<TreeNode> it = q.descendingIterator();
                while (it.hasNext()) {
                    list.add(it.next().val);
                }
            }
            int cur = 0;
            while (cur < size) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
                cur ++;
            }
            res.add(list);
        }
        return res;
    }
}
