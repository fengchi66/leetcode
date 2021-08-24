package leetcode.editor.cn;

//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,104] 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 195 👎 0

/**
 * date: 2021-08-24 21:12:38
 * title: 找树左下角的值
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution513 {
    // 层序遍历：最低一层左边的值就是每一层遍历完的时候，下一次将要遍历的节点
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);
        int ans = root.val;

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) queue2.offer(node.left);
            if (node.right != null) queue2.offer(node.right);

            // 当前层遍历完了,下一个将要遍历的节点就是左边的
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if (!queue1.isEmpty()) {
                    ans = queue1.peek().val;
                }
            }
        }
        return ans;
    }
//leetcode submit region end(Prohibit modification and deletion)

}