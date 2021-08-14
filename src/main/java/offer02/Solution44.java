package offer02;

import bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 剑指 Offer II 044. 二叉树每层的最大值
public class Solution44 {

    // 用一个队列实现二叉树的广度优先搜索
    public List<Integer> largestValues(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        if (root == null) return ans;

        // 首先将root加入到队列,cur = 1, next = 0;
        // cur记录遍历的这一层位于队列中的节点数目，next记录遍历的下一层位于队列中的节点数目
        queue.offer(root);
        int cur = 1;
        int next = 0;

        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            // 每当从队列中取出元素时，cur--
            TreeNode node = queue.poll();
            cur--;
            max = Math.max(max, node.val);

            // 将左右子节点加入队列,同时next++
            if (node.left != null) {
                queue.offer(node.left);
                next++;
            }

            if (node.right != null) {
                queue.offer(node.right);
                next++;
            }
            // 当cur == 0时，说明这一层遍历完了
            if (cur == 0) {
                ans.add(max);
                max = Integer.MIN_VALUE;
                cur = next;
                next = 0;
            }
        }
        return ans;
    }

    // TODO 用一个队列实现二叉树的广度优先搜索
    public List<Integer> largestValues2(TreeNode root) {
        return null;
    }

}
