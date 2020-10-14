package review_jz.链表;

import java.util.Scanner;

/**
 * @author LiXiwen
 * @date 2020/1/19 14:58
 */
public class p16_合并两个排序的链表 {
    private static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(){}
    }
    @SuppressWarnings("Duplicates")
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            String[] s1 = sc.nextLine().split(" ");
            String[] s2 = sc.nextLine().split(" ");
            int[] a1 = new int[s1.length];
            int[] a2 = new int[s2.length];
            for (int i = 0; i < s1.length; i++) {
                a1[i] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i < s2.length; i++) {
                a2[i] = Integer.parseInt(s2[i]);
            }
            ListNode head1 = new ListNode(a1[0]);
            ListNode head2 = new ListNode(a2[0]);
            head1.next = null;
            ListNode r1 = head1;
            ListNode r2 = head2;
            for (int i = 1; i < a1.length; i++) {
                ListNode node = new ListNode(a1[i]);
                node.next = null;
                r1.next = node;
                r1 = node;
            }
            for (int i = 1; i < a2.length; i++) {
                ListNode node = new ListNode(a2[i]);
                node.next = null;
                r2.next = node;
                r2 = node;
            }
            print(head1);
            print(head2);
            ListNode rt = merge(head1, head2);
            print(rt);
        }
    }

    @SuppressWarnings("Duplicates")
    private static ListNode merge(ListNode head1, ListNode head2) {
        if (null == head1) {
            return head2;
        }
        if (null == head2) {
            return head1;
        }
        if(head1 == null && head2 == null){
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = null;
        ListNode p1 = head1, p2 = head2;
        ListNode root = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                head.next = p1;
                head = p1;
                p1 = p1.next;
            } else if (p1.val == p2.val) {
                head.next = p1;
                head = p1;
                p1 = p1.next;
                p2 = p2.next;
            } else {
                head.next = p2;
                head = p2;
                p2 = p2.next;
            }
        }

        head.next = (p1 != null) ? p1 : p2;

        return root.next;
    }

    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }

    private static void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

}
