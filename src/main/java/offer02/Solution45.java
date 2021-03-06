package offer02;

import bean.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

// 剑指 Offer II 045. 二叉树最底层最左边的值
public class Solution45 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);
        // ans表示每一层最左边的值
        int ans = root.val;

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();

            if (node.left != null)
                queue2.offer(node.left);
            if (node.right != null)
                queue2.offer(node.right);

            // 每当遍历完一层时，就将ans更新为该层的第一个值，也就是队首元素
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();

                if (!queue1.isEmpty())
                    ans = queue1.peek().val;
            }
        }

        return ans;

    }
}
