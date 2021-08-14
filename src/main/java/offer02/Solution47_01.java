package offer02;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 二叉树的遍历
public class Solution47_01 {

    // 二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // 先将root加入到stack中
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ans.add(node.val);

            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
        }
        return ans;
    }

    // 后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        // 先将root加入到stack中
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);

        // 头 -> 右 -> 左
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            // 此时不是直接输出，而是加入到s2中
            s2.push(node);

            if (node.left != null)
                s1.push(node.left);
            if (node.right != null)
                s1.push(node.right);
        }

        // 左 -> 右 -> 头
        while (!s2.isEmpty()) {
            ans.add(s2.pop().val);
        }
        return ans;
    }

}
