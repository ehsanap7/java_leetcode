package stack;

import java.util.Stack;

public class RemoveDuplicates {

    public String removeDuplicates(String s) {

        Stack<Character> characterStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (characterStack.isEmpty()) {
                characterStack.push(c);
            } else {
                if (characterStack.peek() == c) {
                    characterStack.pop();
                } else {
                    characterStack.push(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder(characterStack.size());

        for (Character c : characterStack) {
            ans.append(c);
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abbaca"));
    }

}
