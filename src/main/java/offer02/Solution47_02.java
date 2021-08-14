package offer02;

import bean.TreeNode;

// 剑指 Offer II 047. 二叉树剪枝
// 树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
public class Solution47_02 {
    // 递归函数，返回某子树剪枝后的头节点
    // 这个题至下而上递归就完事了，和二叉树翻转那个题差不多
    public TreeNode pruneTree(TreeNode root) {
        // base case
        if (root == null) return null;

        root.left = pruneTree(root.left); // 左子树剪枝
        root.right = pruneTree(root.right); // 由子树剪枝

        // 如何由左右子树组成一颗新的树
        // 如果左右子树都是nul，且自己是0，则将自己变成null返回；否则就返回自己
        if (root.left == null && root.right == null && root.val == 0)
            return null;

        return root;
    }

}
