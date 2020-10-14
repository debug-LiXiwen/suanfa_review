package review_jz.数组;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author LiXiwen
 * @date 2020/3/18 11:02
 */
public class p63_数据流中的中位数 {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());

    int c = 0;

    public void Insert(Integer num) {
        if ((c & 1) == 0) {
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else {
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        c++;
    }

    public Double GetMedian() {
        if ((c & 1) == 0) {
            return new Double(minHeap.peek() + maxHeap.peek());
        } else {
            return new Double(minHeap.peek());
        }
    }


}
