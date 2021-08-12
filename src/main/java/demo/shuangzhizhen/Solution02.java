package demo.shuangzhizhen;

// 11. 盛最多水的容器
public class Solution02 {

    // 双指针
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        int i = 0;
        int j = height.length - 1;
        int ans = 0;

        while (i < j) {
            ans = Math.max(ans, Math.min(height[i], height[j]) * (j-i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;

    }
}
