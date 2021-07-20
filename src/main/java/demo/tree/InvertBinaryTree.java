package demo.tree;

// 226:翻转二叉树
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.left  = rightNode;
        root.right = leftNode;

        return root;

    }
}
