package offer02;

import bean.ListNode;

import java.util.Stack;

// 剑指 Offer II 027. 回文链表
public class Solution27 {
    // 思路同第26题，先将链表分为两部分，然后将后半部分反转,在判断是否相等
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        // 找到链表的中点
        ListNode mid = getMidNode(head);

        ListNode l2 = mid.next;
        mid.next = null;
        ListNode l1 = head;
        // 将l2反转
        l2 = reverseList(l2);

        // 判断l1和l2是否相等
        return equal(l1, l2);
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

    private boolean equal(ListNode head1, ListNode head2) {
        ListNode p1 = head1;
        ListNode p2 = head2;

        while (p1 != null && p2 != null) {
            if (p1.val != p2.val)
                return false;
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null)
            return true;

        Stack<ListNode> stack = new Stack<>();
        // 将链表加入到stack中
        ListNode p1 = head;
        while (p1 != null) {
            stack.push(head);
            p1 = head.next;
        }

        ListNode p2 = head;
        while (stack.isEmpty()) {
            ListNode node = stack.pop();
            if (node.val != p2.val)
                return false;
            p2 = p2.next;
        }
        return true;
    }
}
