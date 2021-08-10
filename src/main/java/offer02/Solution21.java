package offer02;

import bean.ListNode;


// 删除链表的倒数第n个节点
public class Solution21 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode p1 = head;
        ListNode p2 = dummy;

        // 先将p1指针向前移动n个位置
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // 当p1 == null时，此时的p2就是待删除结点的上一个位置
        p2.next = p2.next.next;

        return dummy.next;

    }
}
