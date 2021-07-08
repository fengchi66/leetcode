package code.class12;

import java.util.LinkedList;

public class Code01_IsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static boolean isCBT1(Node head) {
        if (head == null) {
            return true;
        }
        LinkedList<Node> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;

        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            Node l = head.left;
            Node r = head.right;
            // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
            if ((leaf && (l != null || r != null)) || (l == null && r != null))
                return false;
            if (l != null)
                queue.add(l);
            if (r != null)
                queue.add(r);
            if (l == null || r == null)
                leaf = true;
        }
        return true;
    }
}
