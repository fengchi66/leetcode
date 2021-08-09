package offer02;

// 剑指 Offer II 018. 有效的回文
public class Solution18 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;

        int L = 0;
        int R = s.length() - 1;

        while (L < R) {
            char c1 = s.charAt(L);
            char c2 = s.charAt(R);
            if (!Character.isLetterOrDigit(c1)) // 如果不是数字或者字母，则忽略
                L++;
            else if (!Character.isLetterOrDigit(c2))
                R--;
            else {
                char ch1 = Character.toLowerCase(c1);
                char ch2 = Character.toLowerCase(c2);
                if (ch1 != ch2) return false;
            }
            L++;
            R--;
        }
        return true;
    }

}
