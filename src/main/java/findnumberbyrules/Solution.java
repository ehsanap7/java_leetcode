package findnumberbyrules;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<Integer> giveNumberInRule(int[] list) {

        Set<Integer> integers = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for (int i : list) {
            integers.add(i);
        }

        for (Integer integer : list) {
            if (!(integers.contains(integer + 1) || integers.contains(integer - 1))) {
                ans.add(integer);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.giveNumberInRule(new int[]{1, 2, 6, 8, 4, 5, 9, 100}));
    }


}
