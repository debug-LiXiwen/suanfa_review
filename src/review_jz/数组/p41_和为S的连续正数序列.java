package review_jz.数组;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiXiwen
 * @date 2020/1/26 13:35
 */
public class p41_和为S的连续正数序列 {
    public static void main(String[] args) {
        p41_和为S的连续正数序列 a = new p41_和为S的连续正数序列();
        for (int i = 4; i <= 6; i++) {
            //a.FindContinuousSequence(i);
        }
        Queue<Integer> q1 = new LinkedList<>();
        ((LinkedList<Integer>) q1).getLast();
    }


    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int small = 1;
        int big = 2;
        int mid = (sum + 1) >> 1;
        int s = 0;
        while (small < mid) {
            if ((s = getCurSum(small, big)) == sum) {
                res.add(getList(small, big));
                big++;
            } else if (s < sum) {
                big++;
            } else {
                small++;
            }
        }
        return res;
    }

    private ArrayList<Integer> getList(int small, int big) {
        ArrayList<Integer> rs = new ArrayList<Integer>();
        for (int i = small; i <= big; i++) {
            rs.add(i);
        }
        return rs;
    }


    private int getCurSum(int x, int y) {
        return (x + y) * (y - x + 1) / 2;
    }

}
/*
如果small到big序列的数字和小于sum，增加big让范围内包含更多的数字。
如果大于，则增加small，意思就是去掉较小的值，因为至少2个数字序列，
一直增加到small>(s+1)/2为止

例子：sum = 9；
初始：small = 1; big = 2;
然后{1,2}小于9，所以数字数量要增加，增加big，big=3；
此时{1,2,3}；小于10，增加big到4，{1,2,3,4}，此时10 > 9,small向前走，{2,3,4}=9,打印这个序列。

2. 排好序的数组，如果只有两个数字和=sum：
small=1;big =2;
如果small
 */