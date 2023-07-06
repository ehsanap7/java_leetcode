package countingelements;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int countElements(int[] arr) {

        Map<Integer, Integer> integerHashMap = new HashMap<>();

        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            integerHashMap.put(arr[i], i);
        }

        for (Integer i : arr) {
            if (integerHashMap.containsKey(i + 1)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countElements(new int[]{1, 1, 3, 3, 5, 5, 7, 7}));
    }

}
