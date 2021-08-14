package offer02;

import java.util.LinkedList;
import java.util.Queue;

// 剑指 Offer II 042. 最近请求次数
public class Solution42 {

    // 使用队列维持3000的窗口大小,是一个前闭后闭的窗口
    private Queue<Integer> times;
    private int windowSize;
    // 构造函数
    public Solution42() {
        times = new LinkedList<>();
        windowSize = 3000;
    }

    public int ping(int t) {
        // 首先将元素添加到队列中
        times.offer(t);
        // 迭代将不满足窗口大小的元素移除
        while (times.peek() + windowSize < t)
            times.poll();

        return times.size();
    }
}
