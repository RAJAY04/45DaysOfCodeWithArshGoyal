package day15;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesinStringII {
    public static void main(String[] args) {
        String s = "deeedbbcccbdaa";
        int k = 3;
        System.out.println(removeDuplicates(s, k));
    }

    static class Pair{
        char c;
        int count;
        Pair(char c, int count){
            this.c = c;
            this.count = count;
        }
    }
    public static String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek().c == c){
                Pair p = stack.pop();
                p.count++;
                if(p.count < k){
                    stack.push(p);
                }
            }else{
                stack.push(new Pair(c,1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            while(p.count-- > 0){
                sb.append(p.c);
            }
        }
        return sb.reverse().toString();
    }
}
