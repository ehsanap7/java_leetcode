package intersectionofmultiplearrays;

import java.util.*;

public class Solution {

    public List<Integer> intersection(int[][] nums) {
        List<Integer> ansList = new ArrayList<>();
        Map<Integer, Integer> intersectionMap = new HashMap<>();
        for (int[] first : nums) {
            for (int second : first) {
                intersectionMap.put(second, intersectionMap.getOrDefault(second, 0) + 1);
            }
        }
        for (Integer integer : intersectionMap.keySet()) {
            if (intersectionMap.get(integer) == nums.length) {
                ansList.add(integer);
            }
        }

        Collections.sort(ansList); //m.lgm

        return ansList;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().intersection(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

}
