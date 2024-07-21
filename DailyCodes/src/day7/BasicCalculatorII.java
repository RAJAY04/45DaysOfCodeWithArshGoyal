package day7;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        String s = " 3+5 / 2 ";
        System.out.println(calculate(s));
        System.out.println(calculate1(s));
    }

    public static int calculate(String s) {
        s = s.replaceAll("\\s", "");  // Remove all spaces
        String[] parts = s.split("[*/+-]");  // Split by operators
        List<Character> operators = new ArrayList<>();  // Store operators

        // Extract operators
        for (char c : s.toCharArray()) {
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                operators.add(c);
            }
        }

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int num = Integer.parseInt(parts[i]);
        i++;

        for (int j = 0; j < operators.size(); j++) {
            char operator = operators.get(j);
            int nextNum = Integer.parseInt(parts[i]);
            i++;

            if (operator == '*' || operator == '/') {
                if (operator == '*') {
                    num *= nextNum;
                } else if (operator == '/') {
                    num /= nextNum;
                }
            } else {
                stack.push(num);
                num = nextNum;
                if (operator == '+') {
                    // Addition: Update `num`
                } else if (operator == '-') {
                    num = -num;
                }
            }
        }

        stack.push(num);  // Push the last number

        // Compute addition and subtraction from the stack
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static int calculate1(String s) {
        int len = s.length();
        if(s == null || len == 0)return 0;
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for(int i = 0 ; i < len ;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
            }
            if((!Character.isDigit(c) && c != ' ') || i == len - 1){
                if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '+'){
                    stack.push(num);
                }else if(sign == '*'){
                    stack.push(stack.pop() * num);
                }else if(sign == '/'){
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }

        }

        int res = 0;
        while(!stack.isEmpty())res += stack.pop();
        return res;
    }
}
