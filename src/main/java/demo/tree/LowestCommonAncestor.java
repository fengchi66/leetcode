package demo.tree;

// 236:二叉树最低公共祖先
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).ans;
    }


    public Info process(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null)
            return new Info(false, false, null);

        Info leftInfo = process(root.left, p, q);
        Info rightInfo = process(root.right, p, q);

        // 左树上发现A或者右树上发现A或者自己就是A
        boolean findA = leftInfo.findA || rightInfo.findA || root == p;
        boolean findB = leftInfo.findB || rightInfo.findB || root == q;

        // 公共祖先
        TreeNode ans = null;
        if (leftInfo.ans != null)
            ans = leftInfo.ans;
        else if (rightInfo.ans != null)
            ans = rightInfo.ans;
        else { // 左树上没答案，右树上也没答案,同时自己同时发现A和B，那么自己就是答案
            if (findA && findB)
                ans = root;
        }

        return new Info(findA, findB, ans);
    }

    public class Info {
        boolean findA; //是否发现A
        boolean findB; // 是否发现B
        TreeNode ans;

        public Info(boolean findA, boolean findB, TreeNode ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

}
