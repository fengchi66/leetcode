package leetcode.editor.cn;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 975 👎 0

/**
 * date: 2021-08-24 23:38:53
 * title: 二叉树的层序遍历
 */
//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) return ans;

        // 存每一层的节点
        List<Integer> mid = new ArrayList<>();

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();
            mid.add(node.val);

            if (node.left != null) queue2.offer(node.left);
            if (node.right != null) queue2.offer(node.right);

            // 当前层遍历完的时候，将mid加入到ans中，同时初始化mid
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                ans.add(mid);
                mid = new ArrayList<>();
            }
        }
        return ans;
    }
}