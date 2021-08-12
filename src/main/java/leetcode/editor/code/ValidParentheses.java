package leetcode.editor.code;

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2478 👎 0

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();

        String a = "{[]}";
        String b = "()[]{}";

        System.out.println(solution.isValid(b));

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {

        int n = s.length();
        if (n  % 2 == 1) return false;

        HashMap<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
//                System.out.println(stack);
                if (stack.isEmpty() || stack.pop() != pairs.get(ch)) {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}