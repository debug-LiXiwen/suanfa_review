package review_jz.字符串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LiXiwen
 * @date 2020/3/14 22:02
 */
public class leetcode_46_全排列 {

    public static void main(String[] args) {
        leetcode_46_全排列 a = new leetcode_46_全排列();
        int[] nums = {1,2,3};
        List<List<Integer>> res = a.permute(nums);
        res.forEach(x -> System.out.print(x + " "));
    }

    List<List<Integer>> res = new ArrayList<>();
    int[] used;

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        used = new int[nums.length];
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
            list.add(nums[i]);
            used[i] = 1;
            backtrack(nums, list);
            list.remove(list.size() - 1);
            used[i] = 0;
        }
    }
}

/*

 */