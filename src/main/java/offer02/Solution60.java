package offer02;

import java.util.*;

// 剑指 Offer II 060. 出现频率最高的 k 个数字
public class Solution60 {

    public int[] topKFrequent(int[] nums, int k) {
        // map存储每个数字以及次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 按照count排序且大小为k的最小堆
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // 如果最小堆中元素小于k，直接加入
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else { // 如果当前count大于堆顶元素，则移除堆顶元素再加入
                if (entry.getValue() > minHeap.peek().getValue()) {
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }

        // 将最小堆中的k个元素取出
        int[] ans = new int[k];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : minHeap) {
            ans[i++] = entry.getKey();
        }
        return ans;

    }


}
