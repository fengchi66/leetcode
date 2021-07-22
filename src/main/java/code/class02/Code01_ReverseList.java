package code.class02;

// 反转链表
public class Code01_ReverseList {

    public ListNode reverseList(ListNode head) {
        // 双指针法
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next; // 临时变量
            // curr指向pre
            cur.next = pre;
            // pre和curr向后移动一位
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
