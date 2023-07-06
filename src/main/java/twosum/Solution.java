package twosum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        int[] ans = new int[0];

        for (int i = 0; i < nums.length; i++) {
            int goal = target - nums[i];
            if (numMap.containsKey(goal)) {
                return new int[]{numMap.get(goal), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{-1, 1};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] slist = (s.twoSum(new int[]{2, 7, 11, 15}, 9));
        for (int i : slist) {
            System.out.println(i);
        }
    }

}