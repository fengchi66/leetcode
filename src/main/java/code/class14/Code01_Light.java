package code.class14;

/**
 * 照亮街道最少的灯
 */
public class Code01_Light {

    public static int minLight(String road) {
        char[] str = road.toCharArray();
        int index = 0;
        int light = 0;

        while (index < str.length) {
            if (str[index] == 'X') { // 如果遍历到X，直接索引增加
                index ++;
            } else { // 如果遇到.
                light ++;
                if (index + 1 == str.length)
                    break;
                else
                    if (str[index + 1] =='X')
                        index += 2;
                    else
                        index += 3;
            }
        }
        return light;
    }


}
