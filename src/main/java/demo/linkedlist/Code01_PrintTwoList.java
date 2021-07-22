package demo.linkedlist;


import bean.ListNode;

// 打印两个有序链表的公共部分
public class Code01_PrintTwoList {
    /**
     * 如果 head1 的值小于head2，则head1 往下移动。
     * 如果 head2 的值小于head1，则head2 往下移动。
     * 如果 head1 的值与head2 的值相等，则打印这个值，然后head1 与head2 都往下移动。
     * head1 或head2 有任何一个移动到null，则整个过程停止。
     */
    public void print(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val)
                head1 = head2.next;
            else if (head2.val < head1.val)
                head2 = head1.next;
            else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

}
