package leetcode.editor.code;

//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
// 
// 
// Related Topics 递归 链表 
// 👍 1811 👎 0


import bean.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();


    }

//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode reverseList(ListNode head) {

            //申请节点，pre和 cur，pre指向null
            ListNode prev = null; // 前一节点
            ListNode curr = head; // 当前节点

            while (curr != null) {
                //记录当前节点的下一个节点
                ListNode temp = curr.next;
                //然后将当前节点指向pre
                curr.next = prev;
                //pre和cur节点都前进一位
                prev = curr;
                curr = temp;

            }
            return prev;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}