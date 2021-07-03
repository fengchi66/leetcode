package code.class11;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 二叉树可以通过先序、后序或者按层遍历的方式序列化和反序列化，
 * 以下代码全部实现了。
 * 但是，二叉树无法通过中序遍历的方式实现序列化和反序列化
 * 因为不同的两棵树，可能得到同样的中序序列，即便补了空位置也可能一样。
 * 比如如下两棵树
 *         __2
 *        /
 *       1
 *       和
 *       1__
 *          \
 *           2
 * 补足空位置的中序遍历结果都是{ null, 1, null, 2, null}
 *
 * */
public class Code02_SerializeAndReconstructTree {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 先序的方式序列化
     *
     * @param root
     * @return
     */
    public static Queue<String> preSerial(Node root) {
        Queue<String> res = new LinkedList<>();
        pres(root, res);

        return res;
    }

    // 先序遍历,遇到null时将null加入到队列中
    public static void pres(Node root, Queue<String> res) {
        if (root == null) {
            res.add(null);
        } else {
            res.add(String.valueOf(root.value));
            pres(root.left, res);
            pres(root.right, res);
        }
    }

    /**
     * 层序序列化
     *
     * @param head
     * @return
     */
    public static Queue<String> levelSerial(Node head) {
        Queue<String> ans = new LinkedList<>();
        // 1. 如果为空树，返回null
        if (head == null) {
            ans.add(null);
        } else {
            ans.add(String.valueOf(head.value));
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(head);
            while (!queue.isEmpty()) {
                head = queue.poll(); // head 父   子
                // 2. 和层序遍历一样，分别将left、right加入到队列中；left、right为空时也加到结果queue中
                if (head.left != null) {
                    ans.add(String.valueOf(head.left.value));
                    queue.add(head.left);
                } else {
                    ans.add(null);
                }
                if (head.right != null) {
                    ans.add(String.valueOf(head.right.value));
                    queue.add(head.right);
                } else {
                    ans.add(null);
                }
            }
        }
        return ans;
    }

}
