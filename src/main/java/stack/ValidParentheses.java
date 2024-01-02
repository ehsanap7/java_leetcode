package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put('(', ')');
        characterMap.put('{', '}');
        characterMap.put('[', ']');

        Stack<Character> characterStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (characterMap.containsKey(c)) {
                characterStack.push(c);
            } else {
                if (characterStack.isEmpty()) {
                    return false;
                }
                Character last = characterStack.pop();
                if (characterMap.get(last) != c) {
                    return false;
                }
            }
        }

        return characterStack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("({})"));
    }

}
