package offer02;

import bean.TreeNode;
import jdk.nashorn.internal.ir.CallNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 剑指 Offer II 043. 往完全二叉树添加节点
// 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
public class Solution43 {

    private Queue<TreeNode> queue;
    private TreeNode root;

    public Solution43(TreeNode root) {
        this.root = root;
        queue = new LinkedList<>();

        // 将root添加到队列
        queue.offer(root);
        // 当它的左右子树都不为null是，加入队列，目的是找到第一个缺少左子树或者右子树的节点
        while (queue.peek().left != null && queue.peek().right != null) {
            TreeNode node = queue.poll();
            queue.offer(node.left);
            queue.offer(node.right);
        }
    }

    // 插入一个元素
    public int insert(int v) {
        // 此时队列中的第一个元素就是第一个左右子树不双全的节点
        TreeNode parent = queue.peek();
        TreeNode node = new TreeNode(v);

        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
            // 当prent的右子树节点被添加后，说明它的左右子树已经双全了，此时弹出parent，同时将它的左右子树添加到队列
            queue.poll();
            queue.offer(parent.left);
            queue.offer(parent.right);
        }
        return parent.val;
    }

    // 返回root
    public TreeNode get_root() {
        return this.root;
    }

    // 二叉树的层序遍历(宽度优先搜索),层序遍历时要记得将root弹出
    // TODO 二叉树的层序遍历的过程好需要再理解
    public List<Integer> bfs(TreeNode root) {
        // 队列用来存二叉树中元素
        Queue<TreeNode> queue = new LinkedList<>();
        // 结果
        List<Integer> ans = new ArrayList<>();

        if (root == null)
            return ans;

        // 先将root接入到队列
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 队列中弹出元素，加入到结果中
            TreeNode node = queue.poll();
            ans.add(node.val);

            // 先将left加入到队列中
            if (node.left != null)
                queue.offer(node.left);

            if (node.right != null)
                queue.offer(node.right);
        }
        return ans;
    }

}
