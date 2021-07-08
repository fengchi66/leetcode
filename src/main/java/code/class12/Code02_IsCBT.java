package code.class12;

import scala.util.Right;

/**
 * 判断二叉树是否是搜索二叉树
 */
public class Code02_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    // 判断二叉树是否是搜索二叉树
    public static boolean isBST(Node node) {
        return process(node).isBST;
    }

    // 递归函数
    public static Info process(Node x) {
        // base case
        if (x == null) // 不知道如何初始化就返回null，在上游去处理null
            return null;

        // 向左树和右树要信息
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        // 先假设自己的值是最大值,然后依次去和左、右树比较
        int max = x.value;
        if (leftInfo != null)
            max = Math.max(max, leftInfo.max);
        if (rightInfo != null)
            max = Math.max(max, rightInfo.max);

        // 同理，最小值取值
        int min = x.value;
        if (leftInfo != null)
            min = Math.min(min, leftInfo.min);
        if (rightInfo != null)
            min = Math.max(min, rightInfo.min);

        // 先认为自己是搜索二叉树，看那些情况下会违反
        boolean isBST = true;
        // 1. 左树不是搜索二叉树
        if (leftInfo != null && !leftInfo.isBST)
            isBST = false;
        // 2. 右树不是搜索二叉树
        if (rightInfo != null && !rightInfo.isBST)
            isBST = false;
        // 3. 左树不为空且左树最大值不小于当前X的值
        if (leftInfo != null && leftInfo.max >= x.value)
            isBST = false;
        // 4. 右树不为空且右树最大值不大于当前X的值
        if (rightInfo != null && rightInfo.min <= x.value)
            isBST = false;

        return new Info(isBST, max,min);

    }

    public static class Info {
        public boolean isBST; // 是否是搜索二叉树
        public int max; // 最大值
        public int min; // 最小值

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }

}
