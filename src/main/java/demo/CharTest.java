package demo;

public class CharTest {

    public static void main(String[] args) {

        String s = "cbacdcbc";

        char[] chars = s.toCharArray();
        int[] lastInx = new int[26];

        for (int i = 0; i < chars.length ; i++) {
            lastInx[chars[i] - 'a'] = i; //记录每个元素最后一次出现的位置
            System.out.println(chars[i] - 'a');
        }

    }


}
