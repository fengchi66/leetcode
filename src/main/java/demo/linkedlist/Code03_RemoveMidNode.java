package demo.linkedlist;

import bean.ListNode;

// 删除链表的中间结点
public class Code03_RemoveMidNode {

    public ListNode remove(ListNode head) {
        ListNode dummyHead = new ListNode(-1, head);

        return dummyHead.next;
    }
}
