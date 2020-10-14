package review_jz.栈和队列;

import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/3/13 16:19
 */
public class 栈的最小值 {
    class MinStack {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {
        }

        public void push(int x) {
            s1.push(x);
            if (s2.isEmpty()) {
                s2.push(x);
            } else {
                s2.push(Math.min(x, s2.peek()));
            }
        }

        public void pop() {
            if (!s1.isEmpty()) {
                s1.pop();
                s2.pop();
            }
        }

        public int top() {
            return s1.peek();
        }

        public int getMin() {
            return s2.peek();
        }
    }

    class MinStack1 {
        int min = Integer.MAX_VALUE;
        Stack<Integer> s = new Stack<Integer>();
        public void push(int x) {
            // 如果当前值更小，更新min，把min入栈
            if (x <= min) {
                s.push(min);
                min = x;
            }
            s.push(x);
        }

        public void pop() {
            if (s.pop() == min) {
                min = s.pop();
            }
        }

        public int top() {
            return s.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
