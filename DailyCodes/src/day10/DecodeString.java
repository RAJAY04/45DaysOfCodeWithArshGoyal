package day10;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a]20[bc]";
        System.out.println(decodeString(s));
    }

    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == ']'){
                StringBuilder temp = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '['){
                    temp.append(stack.pop());
                }
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    num.append(stack.pop());
                }
                int number = Integer.parseInt(num.reverse().toString());
                StringBuilder sb = new StringBuilder();
                while(number-- > 0){
                    sb.append(temp);
                }
                for(int i = sb.length() - 1 ; i >= 0; i--){
                    stack.add(sb.charAt(i));
                }
            }else stack.add(c);
        }
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
