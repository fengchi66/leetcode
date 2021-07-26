package train.class01;

/**
 * 括号有效配对是指：
 * - 任何一个左括号都能找到和其正确配对的右括号
 * - 任何一个右括号都能找到和其正确配对的左括号
 * - 有效的：(())  ()()   (()())  等 无效的： (()   )(     等。
 * <p>
 * 1. 问题一：怎么判断一个括号字符串有效？
 * 2. 问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
 */
public class Code02_NeedParentheses {

    /**
     * 定义一个count，遍历字符串，`遇到(时：count++，遇到)时count--`
     * 当count < 0时，返回false；
     * 遍历完了之后count != 0，返回false，否则返回true
     *
     * @param s
     * @return
     */
    public static boolean valid(String s) {
        if (s == null || s.length() == 0)
            return false;

        char[] str = s.toCharArray();
        int count = 0;

        for (int i = 0; i < str.length; i++) {
            count += str[i] == '(' ? 1 : -1;

            if (count < 0)
                return false;
        }
        return count == 0;
    }

    public static int needParentheses(String s) {
        char[] str = s.toCharArray();
        int count = 0;
        int need = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                count++;
            } else { // 遇到的是')'
                if (count == 0) {
                    need++;
                } else {
                    count--;
                }
            }
        }
        return count + need;
    }


}
