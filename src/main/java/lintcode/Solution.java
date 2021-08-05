package lintcode;

/**
 * 判断一个字符串忽略大小写和非法字符之后是否是一个回文串
 */
public class Solution {

    public boolean isPalindrome(String s) {
        if (s == null) return false;

        // 定义同向2个指针
        int L = 0;
        int R = s.length() - 1;

        while (L < R) {
            // 如果L位置不是字母，直接L++
            while (L < R && !isValid(s.charAt(L)))
                L++;
            // 如果R位置不是字母，直接R--
            while (L < R && !isValid(s.charAt(R)))
                R--;
            // 判断L位置和R位置是否相等，如果不相等，直接返回false
            if (L < R && !isEqual(s.charAt(L), s.charAt(R)))
                return false;

            L++;
            R--;
        }
        return true;
    }

    // 判断一个字符是否是字母
    private boolean isValid(char c) {
        return Character.isLetter(c) || Character.isDefined(c);
    }

    // 判断两个字符在忽略大小写的情况下是否相等
    private boolean isEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

}
