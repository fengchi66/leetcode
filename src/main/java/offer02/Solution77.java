package offer02;

import bean.ListNode;

import java.util.HashMap;

// 剑指 Offer II 077. 链表排序
// TODO split递归调用栈的深度为O(logN),所以空间复杂度O(logN),leetcode不通过，待优化为O(1)
public class Solution77 {
    // 归并排序的思想
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode head1 = head;
        ListNode head2 = split(head);

        head1 = sortList(head1);
        head2 = sortList(head2);
        // merge
        return merge(head1, head2);
    }

    // 将链表分为两半，并返回后半部分的头结点
    private ListNode split(ListNode head) {
        ListNode p1 = head; // 慢
        ListNode p2 = head; // 快

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        // 此时p1是中间节点
        ListNode tmp = p1.next;
        p1.next = null;

        return tmp;
    }

    // 合并两个有序链表
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p1 = dummyHead;

        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                p1.next = head1;
                head1 = head2.next;
            } else {
                p1.next = head2;
                head2 = head2.next;
            }
            p1 = p1.next;
        }
        // head1还没有遍历完或者head2没有遍历完
        p1.next = head1 == null ? head2 : head1;
        return dummyHead.next;
    }
}
