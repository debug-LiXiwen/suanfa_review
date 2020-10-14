package review_jz.链表;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author LiXiwen
 * @date 2020/1/25 22:05
 */
public class p36_两个链表的第一个公共结点 {
    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * map做
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        while (pHead1 != null) {
            map.put(pHead1.val, 1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (map.containsKey(pHead2.val)) {
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;
    }

    /**
     * 如果两个链表有公共结点，那么公共结点出现在两个链表的尾部。
     * 如果我们从两个链表的尾部开始往前比较，最后一个相同的结点就是我们要找的结点。
     * But，在单链表中只能从头结点开始按顺序遍历，最后才能到达尾结点。
     * 最后到达的尾结点却要最先被比较，这是“后进先出”的特性。
     * 于是，我们可以使用栈的特点来解决这个问题：分别把两个链表的结点放入两个栈里，
     * 这样两个链表的尾结点就位于两个栈的栈顶，接下来比较两个栈顶的结点是否相同。
     * 如果相同，则把栈顶弹出接着比较下一个栈顶，直到找到最后一个相同的结点。
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (pHead1 != null) {
            s1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            s1.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode res = null;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            if (s1.peek() == s2.peek()) {
                res = s1.pop();
                s2.pop();
            } else {
                break;
            }
        }
        return res;
    }

    /**
     * 比较长度，不借助外部空间法，时间复杂度都是O(m+n)
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        int len1 = findNodeLength(pHead1);
        int len2 = findNodeLength(pHead2);
        if (len1 > len2) {
            pHead1 = walkSteps(pHead1, len1 - len2);
        } else {
            pHead2 = walkSteps(pHead2,len2 - len1);
        }
        while (pHead1 != null) {
            if (pHead1 == pHead2) {
                return pHead1;
            }
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }
        return null;
    }

    private ListNode walkSteps(ListNode head, int step) {
        while (step-- > 0) {
            head = head.next;
        }
        return head;
    }

    private int findNodeLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int c = 1;
        while (head != null) {
            c++;
            head = head.next;
        }
        return c;
    }
}
