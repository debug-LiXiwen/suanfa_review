package review_jz.字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author LiXiwen
 * @date 2020/3/14 20:05
 */
public class leetcode_39_组合总和 {

    public static void main(String[] args) {
        leetcode_39_组合总和 a = new leetcode_39_组合总和();
        //int[] candidates = {8,7,4,3};
        int[] candidates = {2,3,6,7};
        List<List<Integer>> res = a.combinationSum(candidates, 7);
        res.forEach(x -> System.out.println(x));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            list.add(candidates[i]);
            System.out.println(i + " : " + list);
            // 元素可以重复使用，所以传递下去的是 i
            backtrack(candidates, target - candidates[i], i, list, candidates.length);
            list.remove(list.size() - 1);
        }
    }

}

/*
给定一个 无重复元素 的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]

输入:
[8,7,4,3]
11
输出
[]
预期结果
[[3,4,4],[3,8],[4,7]]


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println(get(8));

    }

static int s = 0;
static int get(int n) {
        if (n <= 0) {return -1;}
        int[] a = {1,2,5,10};
        backtrack(a,n,0);
        return s;
        }

static void backtrack(int[] a, int n,int start) {
        if (n == 0) {
        s++;
        return;
        }
        for(int i = start; i<a.length && (n - a[i] >= 0) && n >= 0; i++) {
        System.out.println("i = " + i + " , 剩余钱数 n = " + n + " , 组合方式 s = " + s);

        backtrack(a,n-a[i],i);
        //n += a[i];
        }

        }

        }


 */