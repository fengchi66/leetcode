package code.class14;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 会议室宣讲项目最多
 */
public class Code03_BestArrange {

    // 会议实体类
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // 会议的开始时间和结束时间，都是数值，不会 < 0
    public static int bestArrange2(Program[] programs) {
        // 按会议结束时间升序
        Arrays.sort(programs, new ProgramComparator());

        // 一开始的时间点来到0，安排的次数为0
        int timeLine = 0;
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            if (timeLine <= programs[i].start) { // 如果当前时间点小于下一次会议的开始时间，则可以安排一次会议
                res++;
                timeLine = programs[i].end;
            }
        }
        return res;
    }

    // 自定义排序：会议结束时间短的排前面
    public static class ProgramComparator implements Comparator<Program> {
        @Override
        public int compare(Program o1, Program o2) {
            return o1.end - o2.end;
        }
    }

    // 暴力方法，所有情况都尝试
    public static int bestArrange(Program[] programs) {
        if (programs == null || programs.length == 0)
            return 0;
        return process(programs, 0, 0);
    }

    /**
     * 递归函数
     * @param programs 还剩下的会议都放在programs里
     * @param done 之前已经安排了多少会议，数量
     * @param timeLine 表示目前来到的时间点是什么
     * @return
     */
    public static int process(Program[] programs, int done, int timeLine) {
        // base case 已经没有会议需要安排了
        if (programs.length == 0)
            return done;

        // 还有会议可以选择
        int max = done;
        // 当前安排的会议都枚举
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].start >= timeLine) { // 当前会议的start晚于时间点，可以安排
                // 然后将i位置的会议删掉
                Program[] next = copy(programs, i);
                // 将新的数组传入， done +1，同时更新来到的时间点，递归调用
                max = Math.max(max, process(next, done + 1, programs[i].end));
            }
        }

        return 0;
    }

    // 把i位置的会议删掉，返回一个新的数组
    public static Program[] copy(Program[] programs, int i) {
        Program[] ans = new Program[programs.length - 1];
        int index = 0;
        for (int j = 0; j < programs.length; j++) {
            if (j != i)
                ans[index++] = programs[j];
        }
        return ans;
    }


}
