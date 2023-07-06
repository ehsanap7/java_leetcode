package pangram;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean checkIfPangram(String sentence) {
        Set<Character> characterSet = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            characterSet.add(c);
        }
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if(!characterSet.contains(alphabet)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().checkIfPangram("thequickbrooxjumpsoverthelazydog"));
    }

}
