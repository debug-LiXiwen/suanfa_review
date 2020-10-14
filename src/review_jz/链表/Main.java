package review_jz.链表;

import java.util.Scanner;

/**
 * @author LiXiwen
 * @date 2020/1/17 22:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        String[] s = str.split(" ");
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        ListNode head = new ListNode(a[0]);
        head.next = null;
        ListNode r = head;
        for (int i = 1; i < a.length; i++) {
            ListNode t = new ListNode(a[i]);
            t.next = null;
            r.next = t;
            r = t;
        }
       // ListNode node = reverseGroup(head, k);
        ListNode node = solution1(head, k);
        print(node);
    }

    /**
     * 使用循环，非递归
     * @param head
     * @param k
     * @return
     */
    public static ListNode solution1(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode cur = head;
        ListNode node = new ListNode(0);
        node.next = null;
        ListNode pre = node;
        node.next = head;
        for (int i = 1; cur != null; i++) {
            if (i % k == 0) {
                pre = reversePart(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }
        return node.next;
    }

    private static ListNode reversePart(ListNode pre, ListNode next) {
        ListNode l = pre.next;
        ListNode cur = l.next;
        while (cur != next) {
            l.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = l.next;
        }
        return l;
    }

    private static ListNode reverseGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode currentNode = head;
        for (int i = 1; i < k; i++) {
            currentNode = currentNode.next;
            if (currentNode == null) {
                return head;
            }
        }
        ListNode next = currentNode.next;
        reverse(head, currentNode);
        head.next = reverseGroup(next, k);
        return currentNode;
    }

    private static ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode next = null;
        while (pre != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

class NewMain {
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode (int val) {
            this.val = val;
        }
    }

    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        NewMain newMain = new NewMain();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] a = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            a[i] = Integer.parseInt(s[i]);
        }
        ListNode head = new ListNode(a[0]);
        head.next = null;
        ListNode r = head;
        for (int i = 1; i < a.length; i++) {
            ListNode t = new ListNode(a[i]);
            t.next = null;
            r.next = t;
            r = t;
        }
    }


}
