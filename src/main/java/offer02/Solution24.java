package offer02;

import bean.ListNode;

// 剑指 Offer II 024. 反转链表
public class Solution24 {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur !=null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }
}
