package day5;

import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/../..ga/b/.f..d/..../e.baaeeh./.a";
        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        System.out.println(Arrays.toString(parts));

        for(String s : parts){
            if(s.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else if(!s.equals(".") && !s.equals("")){// results in ""
                stack.push(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String dir : stack){
            sb.append("/").append(dir);
        }

        return (sb.length() > 0) ? sb.toString() : "/";

    }
}
