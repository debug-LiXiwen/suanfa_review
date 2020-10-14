package review_jz.链表;

import java.util.Scanner;

/**
 * @author LiXiwen
 * @date 2020/1/17 20:38
 */

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(){}
}

public class 找出单链表节点 {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int k = sc.nextInt();
            ListNode head = new ListNode(1);
            head.next = null;
            ListNode r = head;
            for (int i = 2; i <= 7; i++) {
                ListNode node = new ListNode(i);
                node.next = null;
                r.next = node;
                r = node;
            }
            ListNode rt = FindKthToTail(head, k);
            System.out.println(rt.val);
        }
    }

    private static ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        return solve(head, k);
    }

    /**
     * todo ：两个指针 ：p，q; p先走K步，然后p和q一起走，等到p到头，q节点值就是要找的。
     * @param head
     * @param k
     * @return
     */
    private static ListNode solve(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        int i = 0;
        while (i < k) {
            p = p.next;
            i++;
        }
        while (p != null) {
            q = q.next;
            p = p.next;
        }
        return q;
    }

    /**
     * todo ：for循环，两个指针 ：p，q; p先走K步，然后p和q一起走，等到p到头，q节点值就是要找的。
     * @param head
     * @param k
     * @return
     */
    public static ListNode solve1(ListNode head, int k) {
        ListNode l = head;
        ListNode r = head;
        for (int i = 0; i < k; i++) {
            if (r.next == null) {
                return null;
            }
            r = r.next;
        }
        while (r != null) {
            r = r.next;
            l = l.next;
        }
        return l;
    }

    /**
     * todo ：正着找，计算链表长度，元素对应位置：len-K+1;
     * @param head
     * @param k
     * @return
     */
    public static ListNode solve3(ListNode head, int k) {
        int n = 0;
        ListNode t = head.next;
        while (t != null) {
            n++;
            t=t.next;
        }
        if (n < k) {
            return null;
        }
        ListNode p = head;
        for (int i = 1; i <= n - k; i++) {
            p = p.next;
        }
        return p;
    }
}

