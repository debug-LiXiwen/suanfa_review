package review_jz.链表;

/**
 * @author LiXiwen
 * @date 2020/1/27 10:44
 */
public class p55_链表中环的入口结点 {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private boolean isLoopList = false;

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode meetNode = findLinkedListLoopBegin(pHead);
        if (meetNode == null) {
            return null;
        }
        ListNode p1 = meetNode;
        int n = 1;
        // 得到环中的节点个数
        while (p1.next != meetNode) {
            n++;
            p1 = p1.next;
        }
        // 让p1先走n。
        p1 = pHead;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        ListNode p2 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    private ListNode findLinkedListLoopBegin(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head.next;
        // 题目中链表有一个头结点
        if (slow == null) {
            return null;
        }
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                isLoopList = true;
                return slow;
            }
        }
        return null;
    }

    ListNode find(ListNode node) {
        ListNode l = node.next;
        ListNode f = node.next;
        boolean a = false;
        while (l != null && f != null) {
            l = l.next;
            f = f.next.next;
            if (l == f) {
                a = true;
                return l;
            }
        }
        return null;
    }

    ListNode get(ListNode head) {
        ListNode a = find(head);
        if (a == null) {
            return null;
        }
        int c = 1;
        ListNode p1 = a;
        while (p1 != a) {
            p1 = p1.next;
            c++;
        }
        p1 = head;
        for (int i = 0; i < c; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

}
/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
即两者相遇点即为环的起点位置。

如果链表中环 有n个结点，指针P1在链表上向前移动n步，然后两个指针以相同的速度向前移动。
 当第二个指针指向环的入口结点时，第一个指针已经围绕着环走了一圈又回到了入口结点。
所以首先要得到环中结点的数目。

 */