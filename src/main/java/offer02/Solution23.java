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

}
