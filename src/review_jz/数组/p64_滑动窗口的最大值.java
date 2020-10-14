package review_jz.数组;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author LiXiwen
 * @date 2020/3/18 11:57
 */
public class p64_滑动窗口的最大值 {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }
        LinkedList<Integer> q = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            q.addLast(i);
            if (q.peekFirst() == i - k) {
                q.pollFirst();
            }
            if (i >= k - 1) {
                res[j++] = nums[q.peekFirst()];
            }
        }
        return res;
    }


    public int[] maxSlidingWindow1(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return new int[0];
        }
        //定义结果数组
        int[] res = new int[len - k + 1];
        //maxInd记录每次最大值的下标，max记录最大值
        int maxInd = -1, max = Integer.MIN_VALUE;

        for (int i = 0; i < len - k + 1; i++) {
            //判断最大值下标是否在滑动窗口的范围内
            if (maxInd >= i && maxInd < i + k){
                //存在就只需要比较最后面的值是否大于上一个窗口最大值
                if (nums[i + k - 1] > max){
                    max = nums[i + k - 1];
                    //更新最大值下标
                    maxInd = i + k - 1;
                }
            }
            //如果不在就重新寻找当前窗口最大值
            else {
                max = nums[i];
                for (int j = i; j < i + k; j++) {
                    if (max < nums[j]) {
                        max = nums[j];
                        maxInd = j;
                    }
                }
            }
            res[i] = max;
        }
        return res;
    }


}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k < 1 || nums.length < k) {
            return new int[0];
        }

        int index = 0;
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> qMax = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 在队列不为空的情况下，如果队列尾部的元素要比当前的元素小，或等于当前的元素
            // 那么为了维持从大到小的原则，我必须让尾部元素弹出
            while (!qMax.isEmpty() && nums[qMax.peekLast()] <= nums[i]) {
                qMax.pollLast();
            }
            // 不走 while 的话，说明我们正常在队列尾部添加元素
            qMax.addLast(i);
            // 如果滑动窗口已经略过了队列中头部的元素，则将头部元素弹出
            if (qMax.peekFirst() == (i - k)) {
                qMax.pollFirst();
            }
            // 看看窗口有没有形成，只有形成了大小为 k 的窗口，我才能收集窗口内的最大值
            if (i >= (k - 1)) {
                res[index++] = nums[qMax.peekFirst()];
            }
        }
        return res;
    }
}
