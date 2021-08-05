package demo.linkedlist;

import bean.ListNode;

// 在单链表和双链表中删除倒数第K 个节点
public class Code02_RemoveTopKNode {

    // 删除单链表的倒数第K个节点
    public ListNode remove(ListNode head, int K) {

        // 删除的节点可能就是头结点
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;
        ListNode cur = head;

        // 先将cur向前移动K个结点
        for (int i = 0; i < K; i++)
            cur = cur.next;

        // 向前移动，直到cur == null，此时pre的位置是待删除节点的上一个位置
        while (cur != null) {
            pre = pre.next;
            cur = cur.next;
        }

        // 把当前的pre.next结点删掉
        pre.next = pre.next.next;

        return dummyHead.next;
    }
}
