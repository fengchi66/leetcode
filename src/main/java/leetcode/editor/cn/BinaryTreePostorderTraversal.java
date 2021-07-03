package leetcode.editor.cn;

//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 615 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        // 模拟前序遍历，现将root加入s1中
        s1.push(root);

        while (!s1.isEmpty()) {
            // 从s1中弹出元素加入s2中
            root = s1.pop();
            s2.push(root);

            if (root.left != null)
                s1.push(root.left);
            if (root.right != null)
                s1.push(root.right);
        }
        // 所有元素都按照：头 -> 右 - > 左加入到s2了,从s2取出来就是 左 -> 右 -> 头的关系(后序)
        while (!s2.isEmpty())
            res.add(s2.pop().val);

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}