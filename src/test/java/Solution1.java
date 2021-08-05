public class Solution1 {

    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // write your code here
        if (s == null) return "";

        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // 如果s的长度是奇数，则L和R都是i
            String midAns1 = longPalindrome(s, i, i);
            if (midAns1.length() > ans.length())
                ans = midAns1;
            // 如果s的长度是奇数，则L和R从相邻位置开始
            String midAns2 = longPalindrome(s, i, i + 1);
            if (midAns2.length() > ans.length())
                ans = midAns2;
        }
        return ans;
    }

    // 在字符串s的[L...R]范围内找到最长的回文子串
    private String longPalindrome(String s, int L, int R) {
        while (L >= 0 && R < s.length()) {
            if (s.charAt(L) != s.charAt(R))
                break;
            L++;
            R++;
        }
        return s.substring(L + 1, R);
    }


}
