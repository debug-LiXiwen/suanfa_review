package review_jz.栈和队列;

import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/3/13 16:18
 */
public class 栈实现队列 {
    class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            s1.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!s2.isEmpty()) {
                return s2.pop();
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
