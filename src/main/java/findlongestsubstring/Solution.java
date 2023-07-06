package findlongestsubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int findLongestSubstring(String s, int k) {

        int ans = 0;
        int left = 0;

        Map<Character, Integer> characterIntegerMap = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            characterIntegerMap.put(rightChar, characterIntegerMap.getOrDefault(rightChar, 0) + 1);
            if (characterIntegerMap.size() > k) {
                char leftChar = s.charAt(left);
                characterIntegerMap.put(leftChar, characterIntegerMap.get(leftChar) - 1);
                if (characterIntegerMap.get(leftChar) == 0) {
                    characterIntegerMap.remove(leftChar);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestSubstring("eceba", 2));
    }

}
