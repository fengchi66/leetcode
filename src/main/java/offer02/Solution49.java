package offer02;

import bean.TreeNode;

// 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
public class Solution49 {

    /**
     * 理解二叉树深度优先搜索的递归过程
     */
    public int sumNumbers(TreeNode root) {
        return process(root, 0);
    }

    // 求某一节点到叶子节点的路径数字之和,pre表示上一节点的数字和
    private int process(TreeNode root, int preSum) {
        // base case
        if (root == null) return 0;

        // 截止当前节点的和
        int sum = preSum * 10 + root.val;
        // base case，如果当前节点是叶子节点，直接返回sum
        if (root.left == null && root.right == null)
            return sum;

        return process(root.left, sum) + process(root.right, sum);
    }
}
