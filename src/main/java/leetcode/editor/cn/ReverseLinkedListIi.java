package leetcode.editor.cn;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链
//表节点，返回 反转后的链表 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], left = 2, right = 4
//输出：[1,4,3,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [5], left = 1, right = 1
//输出：[5]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目为 n 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//
// 进阶： 你可以使用一趟扫描完成反转吗？ 
// Related Topics 链表 
// 👍 937 👎 0

import bean.ListNode;

public class ReverseLinkedListIi{
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();



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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1. 创建虚拟头节点
        ListNode dummyHead = new ListNode(-1, head);
        ListNode pre = dummyHead;

        // 2. 到达左节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 3. pre走 right - left +1次找到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 记录一下right的下一个节点，一会连起来
        ListNode leftNode = pre.next;
        ListNode temp = rightNode.next;

        // 4. 切断联系
        pre.next = null;
        rightNode.next = null;

        // 5. 反转链表
        reverse(leftNode);

        // 6. 此时链表已经反转，然后将pre接上rightNode，leftNode接上temp
        pre.next = rightNode;
        leftNode.next = temp;

        return dummyHead.next;

    }

    private void reverse(ListNode head) {

        ListNode pre = null;
        ListNode curr = head;

        while (curr != null) {

            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}