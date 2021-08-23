package leetcode.editor.cn;

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5970 👎 0

import java.util.HashMap;

/**
 * date: 2021-08-22 22:16:51
 * title: 无重复字符的最长子串
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution solution = new Solution3().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 什么是滑动窗口？
         * <p>
         * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，
         * 当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
         * 如何移动？
         * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
         * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
         * 时间复杂度：O(n）
         *
         */
        /**
         * 1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
         * 此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；
         * <p>
         * 2、如果当前字符 ch 包含在 map中，此时有2类情况：
         * 1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
         * 那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
         * 2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
         * 而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
         * 随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
         * 应该不变，left始终为2，子段变成 ba才对。
         * <p>
         * 为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
         * 另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
         * 因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
         */
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0)
                return 0;

            int left = 0;
            int ans = 0;
            // map中存储字符以及字符所对应的索引
            HashMap<Character, Integer> map = new HashMap<>();
            for (int right = 0; right < s.length(); right++) {
                // 当前字符在map中已经存在了
                if (map.containsKey(s.charAt(right))) {
                    left = Math.max(map.get(s.charAt(right)) + 1, left);
                }
                map.put(s.charAt(right), right);
                // 计算长度
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}