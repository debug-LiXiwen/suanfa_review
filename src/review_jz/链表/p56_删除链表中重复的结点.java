package review_jz.链表;

/**
 * @author LiXiwen
 * @date 2020/1/27 11:41
 */
public class p56_删除链表中重复的结点 {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        ListNode pre = head;
        ListNode f = head.next;
        while (f != null) {
            if (f.next != null && f.val == f.next.val) {
                while (f.next != null && f.val == f.next.val) {
                    f = f.next;
                }
                pre.next = f.next;
                f = f.next;
            } else {
                pre = pre.next;
                f = f.next;
            }
        }
        return head.next;
    }

    public ListNode deleteDuplication1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                if (pre == null) {
                    head = cur.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public ListNode deleteDuplication2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.val == head.val) {
            if (head.next.next == null) {
                return null;
            }
            if (head.next.next.val == head.val) {
                return deleteDuplication2(head.next);
            }
            return deleteDuplication2(head.next.next);
        }
        head.next = deleteDuplication2(head.next);
        return head;
    }

    public static ListNode newTest(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = new ListNode(0);
        ListNode pre = node;
        node.next = head;
        ListNode f = head;
        while (f != null) {
            if (f.next != null && f.val == f.next.val) {
                while (f.next != null && f.val == f.next.val) {
                    f = f.next;
                }
                pre.next = f.next;
                f = f.next;
            } else {
                pre = pre.next;
                f = f.next;
            }
        }
        return node.next;
    }
}

/*
样例1

输入：1->2->3->3->4->4->5

输出：1->2->5
样例2

输入：1->1->1->2->3

输出：2->3

1. 首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况

2.设置 pre ，f 指针， pre指针指向当前确定不重复的那个节点，而 f 指针相当于工作指针，一直往后面搜索。
 */