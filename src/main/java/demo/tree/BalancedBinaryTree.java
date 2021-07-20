package demo.tree;

// 110：判断一棵树是否是平衡二叉树
// 对于一颗子树而言，需要它：左右子树是平衡二叉树，且左右子树高度差不超过1，就是平衡二叉树
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public Info process(TreeNode root) {
        // base case
        if (root == null)
            return new Info(0, true);
        // 普遍情况:当前root向左右子树拿到Info
        Info leftInfo = process(root.left);
        Info rightInfo = process(root.right);

        // 树的高度
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        // 是否是平衡二叉树
        boolean isBalanced = true;
        if (!leftInfo.isBalanced)
            isBalanced = false;
        if (!rightInfo.isBalanced)
            isBalanced = false;
        if (Math.abs(leftInfo.height - rightInfo.height) > 1)
            isBalanced = false;

        return new Info(height, isBalanced);
    }

    public class Info {
        int height; // 高度
        boolean isBalanced; // 是否平

        public Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}
