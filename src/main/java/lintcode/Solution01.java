package lintcode;

import bean.TreeNode;

/**
 * 判断二叉树是否是平衡二叉树
 */
public class Solution01 {

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public Info process(TreeNode root) {
        if (root == null)
            return new Info(true, 0);

        // 从左右子树拿到答案
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        // 高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 是否平：左子树为平且右子树为平且左右子树高度差不大于1
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) <= 1 ? true : false;

        return new Info(isBalanced, height);

    }

    private class Info {

        boolean isBalanced; // 是否平
        int height; // 高度

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}
