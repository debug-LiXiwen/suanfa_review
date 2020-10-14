package review_jz.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiXiwen
 * @date 2020/3/14 22:47
 */
public class leetcode_47_全排列2 {

    public static void main(String[] args) {
        leetcode_47_全排列2 a = new leetcode_47_全排列2();
        int[] nums = {1,1,2};
        List<List<Integer>> res = a.permuteUnique(nums);
        res.forEach(x -> System.out.print(x + " "));
    }

    List<List<Integer>> res = new ArrayList<>();
    int[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        used = new int[nums.length];
        // 要先排序，方便重复元素的解决
        Arrays.sort(nums);
        backtrack(nums, list);
        return res;
    }

    @SuppressWarnings("Duplicates")
    private void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 因为全排列需要从头到尾进行遍历，如果有了下一个，但是一定要从头开始
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            // 要保证i-1成立，i必须大于0，必须是前一个节点刚被撤销，又从头开始了。
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            list.add(nums[i]);
            used[i] = 1;
            backtrack(nums, list);
            list.remove(list.size() - 1);
            used[i] = 0;
        }
    }

}

/*
给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */