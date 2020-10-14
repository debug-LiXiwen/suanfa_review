package review_jz.数组;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author LiXiwen
 * @date 2020/1/25 16:50
 */
public class p33_丑数 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isUgly(6));
        System.out.println(isUgly(8));
        System.out.println(isUgly(14));
        //System.out.println(GetUglyNumber_Solution(sc.nextInt()));
    }

    /*public static int GetUglyNumber_Solution(int index) {

    }*/


    public static int GetUglyNumber_Solution1(int index) {
        if(index <= 0) {
            return 0;
        }
        int n = 0;
        int count = 0;
        while (count < index){
            if (isUgly(++n)) {
                count++;
            }
        }

        return n;
    }


    public static boolean isUgly(int num){
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1 ? true : false;
    }


}

/*
把只包含质因子2、3和5的数称作丑数（Ugly Number）。
例如6、8都是丑数，但14不是，因为它包含质因子7。
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。

 */
