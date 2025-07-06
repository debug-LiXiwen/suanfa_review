package review_jz.haha;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiXiwen
 * @date 2020/3/30 17:38
 */
public class Main {

    public static void main(String[] args) {
        NumberOf1Between1AndN_Solution(100);
        NumberOf1Between1AndN_Solution(1000);
        NumberOf1Between1AndN_Solution(10000);
    }

    /**
     * 因为是1-1000，有三个0，所以就是 3/10 * 1000 + 1 = 301.
     * @param n
     * @return
     */
    public static int NumberOf1Between1AndN_Solution(int n) {
        String s = String.valueOf(n);
        int count = ((s.length() - 1) * n) / 10;
        if (s.charAt(0) == '1') {
            count++;
        }
        System.out.println(count);

        return count;
    }


}


class Queue<T> {
    Node pre;
    Node head;
    Node tail;
    Node h = new Node(null);
    class Node {
        T val;
        Node next = null;
        Node (T val) {
            this.val = val;
        }
    }
/*
    int size;
    Lock putLock = new ReentrantLock();
    Lock takeLock = new ReentrantLock();
    Condition putCondition = putLock.Condition();
    Condition putCondition = takeLock.Condition();


    public  void offer (T x) {
        if (x == null) {
            throw new NullPointerException("can be null");
        }

        putLock.lockInterruptly();
        Node node = new Node(x);
        if (size == 0) {
            pre = h;
            h.next = head = tail = node;
        } else {
            pre = pre.next;
            tail = node;
        }
        pre = head;
        size++;
        putLock.unlock();
        takeLock.signalAll();
    }

    public T poll() {
        if (head == tail) {
            return null;
        }

        takeLock.lock();
        T res = head.val;


        h.next = h;
        h = head = null;
        size--;
        takeLock.unlock();
        putLock.signalAll();
        return res;
    }

    public int size() {
        return size;
    }
*/
}