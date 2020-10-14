package review_jz.栈和队列;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author LiXiwen
 * @date 2020/3/13 17:26
 */
public class 队列的最大值 {
    public static void main(String[] args) {
        LinkedBlockingDeque q1 = new LinkedBlockingDeque();
        MaxQueue q = new MaxQueue();
        q.push_back(5);
        q.push_back(3);
        q.push_back(4);
        q.pop_front();
        System.out.println(q.max_value());
    }
}
class MaxQueue {
    LinkedList<Integer> q1 = new LinkedList<>();
    ArrayDeque<Integer> q2 = new ArrayDeque<>();

    public MaxQueue() {
    }

    public int max_value() {
        return q2.isEmpty() ? -1 : q2.getFirst();
    }

    /**
     * 如果当前值比队尾小，直接插入，因为出队列需要用到, 若大于，则把小的出去，把大的放进来
     * @param value
     */
    public void push_back(int value) {
        q1.addLast(value);
        while (!q2.isEmpty() && value > q2.getLast()) {
            q2.removeLast();
        }
        q2.addLast(value);
    }

    public int pop_front() {
        if (q1.isEmpty()) {
            return -1;
        }
        int f = q1.removeFirst();
        if (f == q2.getFirst()) {
            q2.removeFirst();
        }
        return f;
    }
}