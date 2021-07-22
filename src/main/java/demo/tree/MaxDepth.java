package demo.tree;

// 104. 二叉树的最大深度
public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int p1 = maxDepth(root.left);
        int p2 = maxDepth(root.right);
        return Math.max(p1, p2) + 1;
    }
}
