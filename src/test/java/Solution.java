import java.util.HashMap;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i]))
                return new int[]{map.get(target - numbers[i]), i};
            map.put(numbers[i], i);
        }

        return new int[]{};
    }

}
