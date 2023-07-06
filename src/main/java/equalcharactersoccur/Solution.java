package equalcharactersoccur;

import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

    public boolean areOccurrencesEqual(String s) {

        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            characterIntegerMap.put(s.charAt(i), characterIntegerMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        Set<Integer> integerSet = new HashSet<>(characterIntegerMap.values());

        if (integerSet.size() > 1) {
            return Boolean.FALSE;
        } else {
            return Boolean.TRUE;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().areOccurrencesEqual("aaabb"));
    }

}
