package offer02;

import bean.TreeNode;

// 剑指 Offer II 048. 序列化与反序列化二叉树
public class Solution48 {

    // 前序遍历的方式序列化,不能忽略null的节点
    public String serialize(TreeNode root) {
        // base case
        if (root == null) return "#";

        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);

        return String.valueOf(root.val) + "," + leftStr + "," + rightStr;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");
        // 方便字符串下标更新，这里使用数组
        int[] i = {0};

        return dfs(arr, i);

    }

    // 从字符串数组中取出一个字符并以此反序列化出一个节点，如果是"#"则返回null
    private TreeNode dfs(String[] strs, int[] i) {
        String str = strs[i[0]];
        i[0]++;

        if (str.equals("#")) return null;

        // 由左右子树构建当前树
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(strs, i);
        node.right = dfs(strs, i);

        return node;
    }

}
