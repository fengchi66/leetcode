package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1662 👎 0

public class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();

        String str1 = "hadoop";
        String str2 = "hadoew";
        String s = solution.longestCommonPrefix(str1, str2);

        System.out.println(s);

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0)
            return "";

        String prefix = strs[0];


        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);

            if (prefix.length() == 0)
                break;
        }

        return prefix;


    }

    // 由两个字符串寻找公共前缀
    public String longestCommonPrefix(String str1, String str2) {

        int len = Math.min(str1.length(), str2.length());

        int index = 0;

        while (index < len && str1.charAt(index) == str2.charAt(index))
            index ++;

        return str1.substring(0, index);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}