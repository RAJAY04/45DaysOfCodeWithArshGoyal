package day15;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens){
            int num;
            if(s.length() == 1 && isOperator(s.charAt(0))){
                int num1 = stack.pop();
                int num2 = stack.pop();
                if(s.charAt(0) == '+'){
                    stack.push(num2 + num1);
                }else if(s.charAt(0) == '-'){
                    stack.push(num2 - num1);
                }else if(s.charAt(0) == '/'){
                    stack.push(num2 / num1);
                }else{
                    stack.push(num2 * num1);
                }
            }else{
                num = Integer.parseInt(s);
                stack.push(num);
            }
        }
        return stack.peek();
    }

    public static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }


}
