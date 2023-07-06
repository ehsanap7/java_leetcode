package firstlettertwice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public char repeatedCharacter(String s) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            if(charSet.contains(c)){
                return c;
            }
            charSet.add(c);
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedCharacter("jkodgypoya"));
    }

}
