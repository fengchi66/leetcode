package demo;

/**
 * 二分查找
 */
public class BinarySearch {

    public static int search(int[] nums, int key) {

        int low = 0;
        int high = nums.length -1;

        if (key < nums[low] || key > nums[high])
            return -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] < key)
                low = mid + 1;
            else if (nums[mid] > key)
                high = mid -1;
            else
                return mid;
            }

        return -1;
    }

    // 递归方式实现二分查找,增加搜索的上下界作为参数
    public static int search(int[] nums, int key, int from, int to) {

        // 基本判断，当起始位置大于结束位置时，直接返回 -1；特殊情况超出最大最小值直接返回 -1
        if (key < nums[from] || key > nums[to] || from > to)
            return -1;

        // 计算中间位置
        int mid = (from + to)/2;

        // 判断中间位置和key的关系，更改搜索范围，递归调用
        if (nums[mid] < key)
            return search(nums, key, mid + 1, to);
        else if (nums[mid] > key)
            return search(nums, key, from, mid - 1);
        else
            return mid;
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 5, 6, 9, 10};

        int i = search(nums, 3);

        int i1 = search(nums, 3, 0, nums.length - 1);

    }

}
