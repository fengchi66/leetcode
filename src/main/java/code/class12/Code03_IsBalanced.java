package code.class12;

public class Code03_IsBalanced {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 函数，判断二叉树是否是平衡二叉树
    public static boolean isBalanced(Node node) {
        return process(node).isBalanced;

    }

    // 递归函数, 返回Info
    public static Info process(Node x) {
        if (x == null)
            return new Info(true, 0);

        // 默认能向左树和右树拿到信息
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        // 左右树信息求全集，此时得到以X为头的树是否是平的以及高度的信息

        // 高度：左树和右树的最大高度 + 1
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;

        // 判断是不是平的,先假设自己是平的，当左树或者右树不是平的时候，自己也不是平的了
        boolean isBalanced = true;
        if (!leftInfo.isBalanced)
            isBalanced = false;
        if (!rightInfo.isBalanced)
            isBalanced = false;
        // 左右子树高度差大于1，也不平
        if (Math.abs(leftInfo.height - rightInfo.height) > 1)
            isBalanced = false;

        // 返回自己的Info
        return new Info(isBalanced, height);
    }


   // 实体类，定义递归函数的返回结果，也就是x结点要想左、又子树拿到的信息
    public static class Info {
        public boolean isBalanced; // 是否平
        public int height; // 子树的高度

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

}
