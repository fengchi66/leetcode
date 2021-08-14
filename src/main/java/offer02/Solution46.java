package offer02;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 剑指 Offer II 046. 二叉树的右侧视图
public class Solution46 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.offer(root);

        while (!queue1.isEmpty()) {
            TreeNode node = queue1.poll();

            if (node.left != null)
                queue2.offer(node.left);
            if (node.right != null)
                queue2.offer(node.right);

            // 该层遍历完,此时遍历到的node就该层的最后一个节点
            if (queue1.isEmpty()) {
                queue1 = queue2;
                queue2 = new LinkedList<>();
                ans.add(node.val);
            }
        }
        return ans;
    }
}
