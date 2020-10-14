package review_jz.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiXiwen
 * @date 2020/3/14 19:44
 */
public class 字符串的组合 {

    public static void main(String[] args) {
        字符串的组合 a = new 字符串的组合();
        List<List<Integer>> res = a.combine(4, 2);
        res.forEach(x -> System.out.println(x));
    }

    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }

        List<Integer> list = new ArrayList<>();
        backtrack(n, k, list, 1);
        return res;
    }

    private void backtrack(int n, int k, List<Integer> list, int start) {
        // 到达树的尾部
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        // 注意 i 从 start 开始递增，每次递归的时候只在candidates中当前及之后的数字中选择。
        for (int i = start; i <= n; i++) {
            list.add(i);
            backtrack(n, k, list, start + 1);
            list.remove(list.size() - 1);
        }
    }
}

/*
输入两个数字 n, k，算法输出 [1..n] 中 k 个数字的所有组合。

vector<vector<int>> combine(int n, int k);
比如输入 n = 4, k = 2，输出如下结果，顺序无所谓，但是不能包含重复（按照组合的定义，[1,2] 和 [2,1] 也算重复）：

[
[1,2],
[1,3],
[1,4],
[2,3],
[2,4],
[3,4]
]

这就是典型的回溯算法，k 限制了树的高度，n 限制了树的宽度，直接套我们以前讲过的回溯算法模板框架就行了：
 */
