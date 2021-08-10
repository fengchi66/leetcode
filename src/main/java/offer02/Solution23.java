package offer02;

import bean.ListNode;

import java.util.HashSet;

// 剑指 Offer II 023. 两个链表的第一个重合节点
public class Solution23 {

    //  哈希表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = headA;
        while (cur != null) {
            set.add(cur);
            cur = cur.next;
        }

        cur = headB;
        while (cur != null) {
            if (set.contains(cur))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    /**
     * a + c+ b = b + c +a
     * 1. 双指针先放在headA、headB处
     * 2. 当p1为空时，移到headB处；当p2位空时，移到headA处
     * 3. 当p1 == p2时，就是相遇了，此时就是在相交的节点
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

}
