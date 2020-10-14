package review_jz.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiXiwen
 * @date 2020/3/14 21:10
 */
public class leetcode_40_组合总和2 {

    public static void main(String[] args) {
        leetcode_40_组合总和2 a = new leetcode_40_组合总和2();

        int[] candidates = {10,1,2,7,6,1,5};
        List<List<Integer>> res = a.combinationSum2(candidates, 8);
        res.forEach(x -> System.out.println(x));

        /*int[] candidates = {2,5,2,1,2};
        List<List<Integer>> res = a.combinationSum2(candidates, 5);
        res.forEach(x -> System.out.println(x));*/
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, list, candidates.length);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> list, int len) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 设置start，每次递归的时候只在candidates中当前及之后的数字中选择。
        for (int i = start; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, list, candidates.length);
            list.remove(list.size() - 1);
        }
    }
    /*
    List<List<Integer>> res = new ArrayList<>();
    int[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        // 先对数组排序，方便去重
        Arrays.sort(candidates);
        used = new int[candidates.length];
        backtrack(candidates, target, 0, list, candidates.length);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> list, int len) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 设置start，每次递归的时候只在candidates中当前及之后的数字中选择。
        for (int i = start; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            // 判断如果有重复元素，则不行
            if (i > start && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            list.add(candidates[i]);
            used[i] = 1;
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            backtrack(candidates, target - candidates[i], i + 1, list, candidates.length);
            list.remove(list.size() - 1);
            used[i] = 0;
        }
    }*/
}

/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
 */