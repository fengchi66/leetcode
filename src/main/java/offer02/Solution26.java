package offer02;

import bean.ListNode;

// 剑指 Offer II 026. 重排链表
public class Solution26 {

    /**
     * 1. 找到原链表的中点,使用快慢指针来 O(N) 地找到链表的中间节点。
     * 2. 将原链表的右半端反转,使用迭代法实现链表的反转。
     * 3. 将原链表的两端合并,因为两链表长度相差不超过 11，因此直接合并即可。
     */
    public void reorderList(ListNode head) {
        if (head == null)
            return;

        // 1.中间节点
        ListNode mid = getMidNode(head);
        // 2.将原链表的右半端反转
        ListNode l1 = head;
        ListNode l2 = mid.next;
        // 切断mid与后半段的关系
        mid.next = null;
        // 3. 将l2链表反转
        l2 = reverseList(l2);
        // 4. l1与反转后的后半段链表l2合并
        mergeList(l1, l2);
    }

    // 获取链表的中间节点
    private ListNode getMidNode(ListNode head) {
        ListNode p1 = head, p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    // 反转链表
    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // 合并两个链表
    private void mergeList(ListNode l1, ListNode l2) {
        // 使用两个临时节点来保存l1、l2的next
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }
}
