package offer02;

import java.util.LinkedList;
import java.util.Queue;

//剑指 Offer II 041. 滑动窗口的平均值
public class Solution41 {

    // 使用一个队列来维护一个长度为capacity的滑动窗口
    private Queue<Integer> nums;
    private int capacity;
    private int sum;

    // 构造方法
    public Solution41(int size) {
        nums = new LinkedList<>();
        capacity = size;
    }

    // 添加一个元素val，并返回窗口内元素的平均值
    public double next(int val) {
        nums.offer(val);
        sum += val;
        // 如果窗口大小大于capacity了，那么sum减去队列的第一个元素，并且出队
        if (nums.size() > capacity) {
            sum -= nums.poll();
        }
        return (double) sum / nums.size();
    }

    // TODO 扩展：滑动窗口的最大值
    public int maxData(int[] nums, int k) {
        return 0;

    }
}
