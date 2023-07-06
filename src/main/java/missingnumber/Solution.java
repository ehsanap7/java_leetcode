package missingnumber;

import java.util.*;

public class Solution {

    public int missingNumber(int[] nums) {

        Set<Integer> integerSet = new HashSet<>();

        for (int num : nums) {
            integerSet.add(num);
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!(integerSet.contains(i))) {
                return i;
            }
        }

        return 0;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{0, 1}));
    }

}
