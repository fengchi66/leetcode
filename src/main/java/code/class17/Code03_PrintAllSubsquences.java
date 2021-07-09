package code.class17;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串的全部子序列
 */
public class Code03_PrintAllSubsquences {

    // s -> "abc" ->
    public static List<String> subs(String s) {
        char[] str = s.toCharArray();
        String path = "";
        List<String> ans = new ArrayList<>();
        process(str, 0, ans, path);
        return ans;
    }

    /**
     *
     * @param str 固定参数
     * @param index 来到了str[index]字符，index是位置
     * @param ans 把所有生成的子序列，放入到ans里去
     * @param path str[0..index-1]已经走过了！之前的决定，都在path上, 之前的决定已经不能改变了，就是path
     */
    public static void process(char[] str, int index, List<String> ans, String path) {
        if (index == str.length) { // 终止位置，不能再选择
            ans.add(path);
            return;
        }
        // 没有要index位置的字符, path不变
        process(str, index + 1, ans, path);
        // path要上index位置的字符
        process(str, index +1, ans, path + String.valueOf(str[index]));
    }
}
