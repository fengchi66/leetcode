package demo;


import java.util.Stack;

public class Class01 {

    /**
     * 二叉树的前序遍历
     * @param root
     */
    public static  void preOrder(Node root) {

        if (root == null) return;

        Stack<Node> stack = new Stack<>();
        // 先将root加入到Stack中
        stack.add(root);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur);
            // 先将右孩子加入到stack中
            if (cur.right != null)
                stack.add(cur.right);
            if (cur.left != null)
                stack.add(cur.left);
        }
    }
}
