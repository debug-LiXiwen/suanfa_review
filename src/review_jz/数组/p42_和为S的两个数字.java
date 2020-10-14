package review_jz.数组;

import java.util.ArrayList;

/**
 * @author LiXiwen
 * @date 2020/1/26 17:12
 */
public class p42_和为S的两个数字 {

    /**
     * 递增数组，两个数相差越大，乘积越小。
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (array == null || array.length == 0) {
            return res;
        }

        int l = 0;
        int h = array.length - 1;
        int t;
        while (l < h) {
            if ((t = array[l] + array[h]) == sum) {
                res.add(array[l]);
                res.add(array[h]);
                break;
            } else if (t > sum) {
                h--;
            } else {
                l++;
            }
        }

        return res;
    }

}
/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。链接：https://www.nowcoder.com/questionTerminal/12d959b108cb42b1ab72cef4d36af5ec?f=discussion
来源：牛客网

 */