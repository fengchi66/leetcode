package code.class13;

import code.class12.Code01_IsCBT;
import com.sun.tools.corba.se.idl.constExpr.And;

/**
 * 最低公共祖先问题
 */
public class Code03_lowestAncestor {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node lowestAncestor(Node head, Node a, Node b) {
        return process(head, a, b).ans;

    }

    public static Info process(Node x, Node a, Node b) {
        if (x == null)
            return new Info(false, false, null);

        Info leftInfo  = process(x.left, a, b);
        Info rightInfo = process(x.right, a, b);

        // x等于a或者左树发现a或者右树发现a，则当前x为头的树上就发现a了
        boolean findA = (x == a) || leftInfo.findA || rightInfo.findA;
        boolean findB = (x == b) || leftInfo.findB || rightInfo.findB;

        Node ans = null;
        if (leftInfo.ans != null)
            ans = leftInfo.ans;
        else if (rightInfo.ans != null)
            ans = rightInfo.ans;
        else { // 左树上没答案，右树上也没答案
            if (findA && findB)
                ans = x;
        }
        return new Info(findA, findB, ans);
    }

    public static class Info {
        public boolean findA; // 是否发现A
        public boolean findB; // 是否发现B
        public Node ans; // 最低公共祖先

        public Info(boolean findA, boolean findB, Node ans) {
            this.findA = findA;
            this.findB = findB;
            this.ans = ans;
        }
    }

}
