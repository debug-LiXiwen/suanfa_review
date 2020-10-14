package review_jz.链表;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/1/17 21:09
 */
public class 链表反转 {
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
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
        //ListNode node = ReverseList(head);
        ListNode node = reverse(head);
        print(node);
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    /**
     * todo ：使用栈先进后出的特点构造链表，空间复杂度O(n);时间复杂度O(n)
     * @param head
     * @return
     */
    private static ListNode ReverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        if (stack.isEmpty()) {
            return null;
        }
        ListNode r = new ListNode(stack.pop());
        r.next = null;
        ListNode t = r;
        while (!stack.isEmpty()) {
            ListNode node = new ListNode(stack.pop());
            node.next = null;
            t.next = node;
            t = node;
        }
        return r;
    }

    /**
     * 使用两个指针,pre,next;
     * @param head
     * @return
     */
    private static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null; // 当前节点的前一个节点
        ListNode next = null; // 当前节点的下一个节点
        while(head != null){
            next = head.next; // 记录当前节点的下一个节点位置；
            head.next = pre; // 让当前节点指向前一个节点位置，完成反转
            pre = head; // pre 往右走
            head = next;// 当前节点往右继续走
        }
        return pre;
    }
    static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = head;
        ListNode p = head.next;
        pre.next = null;
        ListNode t;
        while (p != null) {
            t = p.next;
            p.next = pre;
            pre = p;
            p = t;
        }
        return pre;
    }
}
/*
实现单链表的逆转函数，输入一个链表，反转链表后，返回翻转之后的链表。
 */