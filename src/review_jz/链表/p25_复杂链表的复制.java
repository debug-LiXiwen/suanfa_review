package review_jz.链表;

import java.util.*;

/**
 * @author LiXiwen
 * @date 2020/1/22 14:20
 */
public class p25_复杂链表的复制 {
    private static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * todo ：插入链表法
     * @param pHead
     * @return
     */
    public RandomListNode Clone1(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        RandomListNode p = pHead;
        // 1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while (p != null) {
            RandomListNode t = new RandomListNode(p.label);
            t.next = p.next;
            p.next = t;
            p = t.next;
        }

        p = pHead;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }

        p = pHead;
        RandomListNode res = pHead.next;
        while (p != null) {
            RandomListNode cn = p.next;
            p.next = cn.next;
            cn.next = cn.next == null ? null : cn.next.next;
            p = p.next;
        }
        return res;
    }

    /**
     * todo ：哈希表法
     * @param head
     * @return
     */
    public RandomListNode Clone(RandomListNode head) {
        return null;
    }
}
