package leetcode.editor.cn;

//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 949 👎 0

import java.util.LinkedList;

/**
 * date: 2021-08-23 21:59:02
 * title: 二叉树的最大深度
 */
class Solution104 {
    // DFS
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    // BFS
    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);
        int ans = 0;
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            if (node.left != null) queue2.offer(node.left);
            if (node.right != null) queue2.offer(node.right);

            // 当前层遍历完了，ans +1
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                ans += 1;
            }
        }
        return ans;
    }
}