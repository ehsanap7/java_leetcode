package stack;

import java.util.Stack;

public class BackSpace {

    public String removeBackspace(String s) {

        Stack<Character> characterStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!characterStack.isEmpty()) {
                    characterStack.pop();
                }
            } else {
                characterStack.push(c);
            }
        }

        StringBuffer sb = new StringBuffer();

        for (Character c : characterStack) {
            sb.append(c);
        }

        return sb.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return removeBackspace(s).equals(removeBackspace(t));
    }

    public static void main(String[] args) {
        new BackSpace().backspaceCompare("ab#c", "ad#c");
    }

}
