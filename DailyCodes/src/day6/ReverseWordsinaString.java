package day6;

import java.util.Stack;

public class ReverseWordsinaString {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] arr = s.split(" ");
        Stack<String> stack = new Stack<>();
        for(String str : arr){
            if(!str.equals("")){
                stack.add(str);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() -1 );
        return sb.toString();
    }
}
