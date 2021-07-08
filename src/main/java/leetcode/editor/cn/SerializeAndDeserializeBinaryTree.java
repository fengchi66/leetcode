package leetcode.editor.cn;

//序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方
//式重构得到原数据。 
//
// 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串
//反序列化为原始的树结构。 
//
// 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的
//方法解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,null,4,5]
//输出：[1,2,3,null,null,4,5]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中结点数在范围 [0, 104] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 字符串 二叉树 
// 👍 592 👎 0

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree{
    public static void main(String[] args) {
        Solution solution = new SerializeAndDeserializeBinaryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = "";
        pres(root, res);

        return res;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // 对于给到的字符串，先转成queue
        String[] arr = data.split(",");
        Queue queue = new LinkedList<String>(Arrays.asList(arr));

        return buildByPreQueue(queue);

    }

    public void pres(TreeNode root, String res) {
        if (root == null) {
            res += "#";
        } else {
            res += String.valueOf(root.val);
            pres(root.left, res);
            pres(root.right, res);
        }
    }

    public TreeNode buildByPreQueue(Queue<String> prelist) {
        if (prelist == null || prelist.size() == 0) return null;
        return preb(prelist);

    }

    public TreeNode preb(Queue<String> prelist) {
        // 出队
        String value = prelist.poll();

        if (value == null) return null;

        TreeNode cur = new TreeNode(Integer.valueOf(value));
        cur.left = preb(prelist);
        cur.right = preb(prelist);

        return cur;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

}