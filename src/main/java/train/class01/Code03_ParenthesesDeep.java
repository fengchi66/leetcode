package train.class01;

/**
 * 括号有效配对是指：1）任何一个左括号都能找到和其正确配对的右括号,2）任何一个右括号都能找到和其正确配对的左括号,
 * 返回一个括号字符串中，最长的括号有效子串的长度。
 */
public class Code03_ParenthesesDeep {

    // 求i位置结尾时的有效子串的长度：在每个位置都求，返回最大值。
    // )())(())()
    // dp[i]表示从0到i位置，有效子串的长度

    /**
     * 动态规划，生成一个记录位置结尾的形成的最长子串的数组。假设我们现在求i位置的最长有效子串的长度，我们已经知道i-1位置的最长有效子串长度为l，
     * 如果此时i位置时左括号，那么此时以i位置结尾不可能形成有效子串，则有效子串长度为0，若是以右括号结尾的那么我们可以看此时从i位置向前推l的长度的前一个位置是否是一个左括号，
     * 若不是则以i位置结尾的最长子串长度为0，若是那么我们可以确定以i位置结尾的最长子串的最小长度是l+2，还能不能更长我们要看此时最少形成的子串的开头位置的前一个位置为结尾的子串的长度相加。
     */
    public static int maxLength(String s) {
        if (s == null || s.length() == 0)
            return 0;

        char[] str = s.toCharArray();
        int dp[] = new int[str.length];
//        dp[0] = 0;
        int pre = 0;
        int res = 0;

        for (int i = 1; i < str.length; i++) {
            // 当遇到的字符为'('的时候，dp[i]一定为0，不用计算
            if (str[i] == ')') {
                // ?....i
                pre = i - dp[i - 1] - 1; // 与str[i]位置配对的左括号的位置
                if (pre >= 0 && str[pre] == '(')
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
            }
            res = Math.max(res, dp[i]);
        }
        return res;

    }

}
