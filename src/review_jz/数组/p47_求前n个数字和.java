package review_jz.数组;

import java.util.stream.IntStream;

/**
 * @author LiXiwen
 * @date 2020/1/26 21:01
 */
public class p47_求前n个数字和 {
    public static void main(String[] args) {

    }

    public int Sum_Solution(int n) {
        int sum = n;
        boolean f = sum > 0 && (sum +=Sum_Solution(--n)) > 0;
        return sum;
    }

    public int getSum(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }

}
/*
求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 public int getSum(int n) {
        return IntStream.rangeClosed(1, n).sum();
    }
 */