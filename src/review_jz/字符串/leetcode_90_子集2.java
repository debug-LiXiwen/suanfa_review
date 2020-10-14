package review_jz.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiXiwen
 * @date 2020/3/14 23:37
 */
public class leetcode_90_子集2 {

    public static void main(String[] args) {
        leetcode_90_子集2 a = new leetcode_90_子集2();
        int[] nums = {1,2,2};
        List<List<Integer>> res = a.subsetsWithDup(nums);
        res.forEach(x -> System.out.println(x));
    }

    //定义结果集
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        // 记录走过的路径
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> list) {
        // 因为求子集，所以每次进来都要添加，如果是求排列，则要遍历完字符串才会添加。
        res.add(new ArrayList<>(list));
        // 注意 i 从 start 开始递增，每次递归的时候只在candidates中当前及之后的数字中选择
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做选择
            list.add(nums[i]);
            // 回溯
            backtrack(nums, i + 1, list);
            // 撤销选择
            list.remove(list.size() - 1);
        }
    }
}

/*
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */