package review_jz.数组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author LiXiwen
 * @date 2020/1/23 15:17
 */
public class p28_数组中出现次数超过一半的数字 {
    public static void main(String[] args) {
        int[] a = {1,2,3,2,2,2,5,4,2};
        MoreThanHalfNum_Solution1(a);
    }

    /**
     * 采用HashMap
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array==null|| array.length<=0){
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int h = array.length >>> 1;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int l = map.get(array[i]) + 1;
                map.put(array[i], l);
                if (l > h) {
                    return array[i];
                }

            } else {
                map.put(array[i], 1);
            }
        }
        return 0;
    }

    /**
     *
     * 采用阵地攻守的思想：
     * 第一个数字作为第一个士兵，守阵地；count = 1；
     * 遇到相同元素，count++;
     * 遇到不相同元素，即为敌人，同归于尽,count--；
     * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
     * 再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
     */
    public static int MoreThanHalfNum_Solution1(int [] array) {
        int c = 1;
        int t = array[0];
        for (int i = 1; i < array.length; i++) {
            if (c == 0) {
                t = array[i];
            } else if (t == array[i]) {
                c++;
            } else {
                c--;
            }
        }
        c = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == t) {
                c++;
            }
        }
        if (c > array.length / 2) {
            return t;
        }
        return 0;
    }


    /**
     * 基于快速排序, todo : 既然超过了一半，那么排序之后中间值就肯定是它
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int q = array.length >> 1;
        int mid = array[q];

        int c = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == mid) {
                c++;
            }
        }
        if (c > q) {
            return mid;
        }
        return 0;
    }

    @SuppressWarnings("Duplicates")
    public static int Partition(int[] a, int p, int r) {
        int i = p;
        int j = r;
        int x = a[i];

        while (i < j) {
            while (i < j && a[j] >= x) {
                j--;
            }
            if (i < j) {
                a[i] = a[j];
            }
            while (i < j && a[i] <= x) {
                i++;
            }
            if (i < j) {
                a[j] = a[i];
            }
        }
        a[i] = x;
        return i;
    }

    public static void quickSort(int[] a, int p, int r) {
        if (p < r) {
            int q = Partition(a, p, r);
            quickSort(a, p, q - 1);
            quickSort(a, q + 1, r);
        }
    }

}
