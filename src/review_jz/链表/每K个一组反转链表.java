package review_jz.链表;

import java.util.Scanner;

/**
 * @author LiXiwen
 * @date 2020/1/17 21:39
 */
public class 每K个一组反转链表 {
    @SuppressWarnings("Duplicates")
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
        //head = head.next;
        ListNode node = reverseGroup(head, k);
        print(node);
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    //不停地取k个进行翻转，如果不够k个，就直接返回,结束
    public static ListNode reverseGroup(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1)
            return head;
        ListNode currentNode = head;
        //获取k个元素的首尾节点
        for (int count = 1; count < k; count++) {
            currentNode = currentNode.next;
            //不够K个则返回
            if(currentNode==null)
                return head;
        }
        ListNode next = currentNode.next;
        //对局部链表进行反转
        reverse(head,currentNode);
        head.next=reverseGroup(next,k);
        return currentNode;
    }

    //写一个头尾节点反转的局部函数
    public static ListNode reverse(ListNode head, ListNode tail) {
        if (head == null || head.next == null)
            return head;
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
}

class TestMain {
    static class ListNode {
        int val;
        ListNode next = null;
        ListNode (int val) {
            this.val = val;
        }
    }

    @SuppressWarnings("Duplicates")
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
        ListNode node = reverse(head, k);
        print(node);
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    private static ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        int i = 1;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode pre = node;
        ListNode p = head;
        while (p != null) {
            if (i % k == 0) {
                pre = re1(pre, p.next);
                p = pre.next;
            } else {
                p = p.next;
            }
            i++;
        }
        return node.next;
    }

    @SuppressWarnings("Duplicates")
    public static ListNode re1(ListNode pre, ListNode next) {
        ListNode l = pre.next;
        ListNode p = l.next;
        while (p != next) {
            l.next = p.next;
            p.next = pre.next;
            pre.next = p;
            p = l.next;
        }
        return l;
    }

    @SuppressWarnings("Duplicates")
    static ListNode reverse1(ListNode head, int k) {
        if (head == null || head.next == null || k <= 1) {
            return head;
        }
        ListNode cur = head;
        for (int i = 1; i < k; i++) {
            cur = cur.next;
            if (cur == null) {
                return head;
            }
        }
        ListNode next = cur.next;
        rever(head, cur);
        head.next = reverse1(next, k);
        return cur;
    }

    @SuppressWarnings("Duplicates")
    static ListNode rever(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


}

