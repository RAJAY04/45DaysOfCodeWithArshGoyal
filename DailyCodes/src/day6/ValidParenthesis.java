package day6;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!stack.isEmpty() && stack.peek() + 1 == c) {
                    stack.pop();
                    continue;
                }
            } else {
                if (!stack.isEmpty() && stack.peek() + 2 == c) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(c);
        }
        return stack.size() == 0;
    }
}
