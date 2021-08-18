package offer02;

public class Solution68_01 {

    // 二分查找:并不是只有排序数组才能二分查找，要注意base case
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 二分查找递归写法
    public int search2(int[] nums, int target) {
        return process(nums, target, 0, nums.length - 1);
    }

    public int process(int[] nums, int target, int left, int right) {
        int mid = left + ((right - left) >> 1);
        // base case
        if (nums[mid] == target) return mid;
            // 普遍情况
        else if (nums[mid] > target) return process(nums, target, left, mid - 1);
        else return process(nums, target, mid + 1, left);
    }

    // 变体一：查找第一个值等于给定值的元素
    public int search3(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {// 当mid的值等于target的时候
                if (mid == 0 || nums[mid - 1] != target) return mid;
                else R = mid - 1;
            }
        }
        return -1;
    }

    // 变体二：查找最后一个值等于给定值的元素
    public int search4(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] > target) {
                R = mid - 1;
            } else if (nums[mid] < target) {
                L = mid + 1;
            } else {// 当mid的值等于target的时候
                if (mid == nums.length - 1 || nums[mid + 1] != target) return mid;
                else L = mid + 1;
            }
        }
        return -1;
    }

    // 变体三：查找第一个大于等于给定值的元素
    public int search5(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) return mid;
                else R = mid - 1;
            } else { // 如果num[mid] < target,那么第一个大于等于肯定不在[L...mid]上，那么更新L
                L = mid + 1;

            }
        }
        return -1;
    }

    // 查找最后一个小于等于给定值的元素
    public int search6(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;

        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (nums[mid] <= target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) return mid;
                else L = mid + 1;
            } else { // 如果num[mid] > target,那么最后一个小于等于给定值的元素肯定不在[mid...R]上，那么更新L
                R = mid - 1;
            }
        }
        return -1;
    }
}
