package stack;

import java.util.Stack;

public class MakeStringGreat {

    public String makeGood(String s) {
        Stack<Character> characterStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (characterStack.isEmpty()) {
                characterStack.push(c);
            } else {
                Character curr = characterStack.peek();
                if (curr != c) {
                    if (Character.toLowerCase(curr) == Character.toLowerCase(c)) {
                        characterStack.pop();
                        continue;
                    }
                }
                characterStack.push(c);
            }
        }
        StringBuffer ans = new StringBuffer();
        for (Character c : characterStack) {
            ans.append(c);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new MakeStringGreat().makeGood("Pp"));
        System.out.println(0 % 10);
    }

}
