package code.class02;

// 删除链表给定的值
public class Code02_RemoveList {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;

        // 对于头结点可能变化的情况，用虚拟节点
        ListNode dummyHead = new ListNode(-1, head);

        // 因为删除的节点可能是head，避免对head的讨论，设置当前节点cur为dummyHead
        ListNode cur = dummyHead;

        while (cur != null) {
            if (cur.next != null && cur.next.val == val)
                // 始终删除的是cur.next这个节点
                cur.next = cur.next.next;
            cur = cur.next;
        }

        return dummyHead.next;
    }

}
