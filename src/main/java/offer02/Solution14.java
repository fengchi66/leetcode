package offer02;

// 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的某个变位词。
public class Solution14 {

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;

        // 使用固定长度数组模拟哈希表，count[0]表示字母a出现的次数，count[1]表示字母b出现的次数...
        int[] counts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            // 计算字符串s1中每个字母出现的次数
            counts[s1.charAt(i) - 'a']++;
            counts[s2.charAt(i) - 'a']--;
        }
        if (areAllZero(counts)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            counts[s2.charAt(i) - 'a']--;
            counts[s2.charAt(i - s1.length()) - 'a']++;

            if (areAllZero(counts)) return true;
        }
        return false;

    }

    // 看数组的元素是不是都为0
    private boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }


}
