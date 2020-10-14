package review_jz.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiXiwen
 * @date 2020/3/14 14:49
 */
public class 字符串的所有子集 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        字符串的所有子集 a = new 字符串的所有子集();
        List<List<Integer>> res = a.subsets(nums);
        res.forEach(x -> System.out.println(x));
        /*res.forEach(list -> {
            list.forEach(x -> System.out.print(x + " "));
            System.out.println();
        });*/
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        dfs(nums, 0);
        return res;
    }

    private void dfs(int[] nums, int start) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    class Solution {
        //定义结果集
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            if (nums == null || nums.length == 0) {
                return res;
            }
            // 记录走过的路径
            List<Integer> list = new ArrayList<>();
            backtrack(nums, 0, list);
            return res;
        }

        private void backtrack(int[] nums, int start, List<Integer> list) {
            // 因为求子集，所以每次进来都要添加，如果是求排列，则要遍历完字符串才会添加。
            res.add(new ArrayList<>(list));
            // 注意 i 从 start 开始递增，每次递归的时候只在candidates中当前及之后的数字中选择
            for (int i = start; i < nums.length; i++) {
                // 做选择
                list.add(nums[i]);
                // 回溯
                backtrack(nums, i + 1, list);
                // 撤销选择
                list.remove(list.size() - 1);
            }
        }
    }
}
/*
对于 abc，所有子集有 a,b,c, ab, ac, bc, abc
所有子串：a,b,c, ab, bc, abc

给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

https://leetcode-cn.com/problems/subsets

//定义结果集
List<List<Integer>> res;

List<List<Integer>> subset(int[] nums) {
    // 记录走过的路径
    List<Integer> list;
    backtrack(nums, 0, list);
    return res;
}

void backtrack(int[] nums, int start, List<Integer> list) {
    // 因为求子集，所以每次进来都要添加，如果是求排列，则要遍历完字符串才会添加。
    res.add(list);
    for (int i = start; i < nums.length; i++) {
        // 做选择
        list.add(nums[i]);
        // 回溯
        backtack(nums, i + 1, list);
        // 撤销选择
        list.remove(list.size() - 1);
    }
}

 */