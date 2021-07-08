package code.class13;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个由字符串组成的数组，必须把所有的字符串拼接起来，**返回所有可能的拼接结果中，字典序最小的结果。
 */
public class Code05_LowestLexicography {

    /**
     * 比较器: 贪心策略
     */
    public static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return (a + b).compareTo(b + a);
        }
    }

    public static String lowestString(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // 对数组按照定义好的比较器排序
        Arrays.sort(strs, new MyComparator());

        String res = "";
        for (int i = 0; i < strs.length; i++) {
            res += strs[i];
        }
        return res;
    }
}
