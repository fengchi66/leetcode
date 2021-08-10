package offer02;

import bean.ListNode;

import java.util.HashSet;

// 剑指 Offer II 022. 链表中环的入口节点
public class Solution22 {
    /**
     * 1. 先判断链表是否有环，如果有，则找一个快慢指针相遇的节点
     * 2. 在绕环一圈，到达相同的位置，得到环的长度
     * 3. 两个指针，p1先走环的长度，然后p1、p2同时移动，会在环的入口处相遇
     */
    public ListNode detectCycle(ListNode head) {

        return null;

    }

    // 哈希表法
    public ListNode detectCycle2(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur))
                return cur;
            else
                set.add(cur);
            cur = cur.next;
        }

        return null;

    }


}
