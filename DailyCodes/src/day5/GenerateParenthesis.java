package day5;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
    public static List<String> generateParenthesis(int n) {
        int leftCount = 0, rightCount = 0;
        List<String> res = new ArrayList<>();
        dfs(n,new StringBuilder(),res,leftCount,rightCount);
        return res;
    }
    public static void dfs(int n , StringBuilder sb , List<String> res, int l , int r){
        if(l == n && r == n){
            res.add(sb.toString());
            return;
        }else if(l > n)return;

        if(l > r){
            sb.append('(');
            dfs(n,sb,res,l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
            sb.append(')');
            dfs(n,sb,res,l, r + 1);
            sb.deleteCharAt(sb.length() - 1);
        }else if(l == r){
            sb.append('(');
            dfs(n,sb,res,l + 1, r);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
