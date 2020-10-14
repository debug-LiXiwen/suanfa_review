package review_jz.栈和队列;

import sun.awt.image.ImageWatched;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author LiXiwen
 * @date 2020/3/13 16:18
 */
public class 队列实现栈 {
    class MyStack {
        LinkedList<Integer> q1;
        LinkedList<Integer> q2;

        /** Initialize your data structure here. */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        // 进栈时，将元素压入不为空的那一个队列即可。如果两队列都为空，随便压入其中一个队列
        public void push(int x) {
            if (empty() || q2.isEmpty()) {
                q1.add(x);
            } else {
                q2.add(x);
            }
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            if (q1.isEmpty()) {
                while (q2.size() > 1) {
                    q1.add(q2.remove());
                }
                return q2.remove();
            }
            while (q1.size() > 1) {
                q2.add(q1.remove());
            }
            return q1.remove();
        }

        /** Get the top element. */
        public int top() {
            int x = pop();
            push(x);
            return x;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    /**
     * 一个队列实现栈
     */
    class MyStack1 {
        private LinkedList<Integer> q1 = new LinkedList<>();

        /**
         * 压入时，调换顺序，队头的出来然后重新从队尾进去，这样新进来的是在最前面
         * @param x
         */
        public void push(int x) {
            q1.add(x);
            int sz = q1.size();
            while (sz > 1) {
                q1.add(q1.remove());
                sz--;
            }
        }

        public int pop() {
            return q1.remove();
        }
        public int top() {
            return q1.peek();
        }
        public boolean empty() {
            return q1.isEmpty();
        }
    }

    /**
     * 改变指针指向避免来回复制
     */
    class MyStack2 {
        private LinkedList<Integer> q1 = new LinkedList<>();
        private LinkedList<Integer> q2 = new LinkedList<>();

        public void push(int x) {
            q2.add(x);
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }
            LinkedList<Integer> t = q1;
            q1 = q2;
            q2 = t;
        }

        public int pop() {
            return q1.remove();
        }
        public int top() {
            return q1.peek();
        }
        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
