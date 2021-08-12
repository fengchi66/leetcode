package leetcode.editor.code;

//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 105 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈
// 👍 590 👎 0

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeKdigits(String num, int k) {

            // 双端队列
            Deque<Character> deque = new LinkedList<Character>();

            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);

                // 当且仅当K>0 并且队尾元素大于要入队的元素的时候就把队尾元素移除掉
                while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                    deque.pollLast();
                    k--;
                }
                // 如果不大于则直接入队
                deque.offerLast(c);
            }
            // 此时如果K还大于0 队列里面的元素已经为单调不降了。则最后依次移除队列尾部剩余的k数次即可，
            for (int i = 0; i < k; i++) {
                deque.pollLast();
            }

            boolean flag = true;
            StringBuffer res = new StringBuffer();

            while (!deque.isEmpty()) {
                Character character = deque.pollFirst();
                //防止前导0 也就是队头第一个元素==0 则需要跳过。
                if (flag && character == '0') {
                    continue;
                }
                flag = false;
                res.append(character);
            }

            //返回结果
            return res.length() == 0 ? "0" : res.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}