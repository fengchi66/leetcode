package leetcode.editor.cn;

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1424 👎 0

import bean.ListNode;

import java.time.Period;

public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 19. 删除链表的倒数第 N 个结点
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyHead = new ListNode(-1, head);

        ListNode pre = dummyHead;
        ListNode curr = head;

        // curr向前移动n个节点
        for (int i = 0; i < n; i++)
            curr = curr.next;

        while (curr != null) {
            pre = pre.next;
            curr = curr.next;

        }

        // 此时curr已经遍历到了最后一个节点,删除pre.next
        pre.next = pre.next.next;

        return dummyHead.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}