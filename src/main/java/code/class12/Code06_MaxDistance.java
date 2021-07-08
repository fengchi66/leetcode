package code.class12;

/**
 * 二叉树上的最大距离
 */
public class Code06_MaxDistance {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int maxDistance(Node head) {
        return process(head).maxDistance;
    }

    // 递归函数
    public static Info process(Node x) {
        // 当x为null时，最大距离和高度设置为0即可
        if (x == null) return new Info(0, 0);

        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int height = Math.max(leftInfo.height , rightInfo.height) + 1;

        // 最大距离，3种情况取最大值
        int p1 = leftInfo.maxDistance;
        int p2 = rightInfo.maxDistance;
        int p3 = leftInfo.height + rightInfo.height + 1;

        int maxDistance = Math.max(Math.max(p1, p2), p3);

        return new Info(maxDistance, height);

    }


    public static class Info {
        public int maxDistance; // 最大距离
        public int height; // 高度

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }

}
