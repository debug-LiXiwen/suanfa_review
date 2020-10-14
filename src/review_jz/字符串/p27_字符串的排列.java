package review_jz.字符串;

import java.util.*;

/**
 * @author LiXiwen
 * @date 2020/1/22 16:57
 */
public class p27_字符串的排列 {

    public static void main(String[] args) {
        p27_字符串的排列 a = new p27_字符串的排列();

        a.Permutation("abc");
        //System.out.println();
        //System.out.println("-----");
        //a.Permutation("aab");
    }

    char[] path;
    int[] f;
    HashSet<String> set = new HashSet<>();

    public ArrayList<String> Permutation(String str) {
        int len;
        ArrayList<String> res = new ArrayList<>();

        if (str == null || (len = str.length()) == 0) {
            return res;
        }
        path = new char[len];
        f = new int[len];
        char[] chars = str.toCharArray();
        dfs(chars, 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    private void dfs(char[] chars, int step) {
        // 满足结束条件:添加结果集
        if (step == chars.length) {
            set.add(String.copyValueOf(path));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (f[i] == 0) {
                // 做选择
                path[step] = chars[i];
                f[i] = 1;
                // 回溯
                dfs(chars, step + 1);
                // 撤销选择
                f[i] = 0;
            }
        }
    }

    class Solution {
        List<List<Integer>> res = new LinkedList<>();

        // 主函数，输入一组不重复的数字，返回它们的全排列
        public List<List<Integer>> permute(int[] nums) {
            // 记录「路径」
            // 这里的 选择列表 即包含在nums中
            LinkedList<Integer> track = new LinkedList<>();
            backtrack(nums, track);
            return res;
        }

        // 路径：记录在 track 中
        // 选择列表：nums 中的元素
        // 结束条件：nums 中的元素全都在 track 中出现
        void backtrack(int[] nums, LinkedList<Integer> track) {
            // 触发结束条件
            if (track.size() == nums.length) {
                res.add(new LinkedList(track));
                return;
            }

            // 注意从0开始，也就是会用重复的
            for (int i = 0; i < nums.length; i++) {
                // 排除不合法的选择
                if (track.contains(nums[i])) {
                    continue;
                }
                // 做选择
                track.add(nums[i]);
                // 进入下一层决策树
                backtrack(nums, track);
                // 取消选择，返回上一层决策树
                track.removeLast();
            }
        }

    }
}


/*
输入一个字符串,按字典序打印出该字符串中字符的所有排列。
例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
