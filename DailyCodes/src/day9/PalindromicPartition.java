package day9;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
    static List<List<String>> res;
    static List<String> list;
    public static List<List<String>> partition(String s) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        backtrack(s,0);
        return res;
    }
    public static void backtrack(String s, int index){
        if(index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = index; i < s.length(); i++){
            String str = s.substring(index,i + 1);
            if(isPalindrome(str)){
                list.add(str);
                backtrack(s,i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int i = 0 , j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i++) != s.charAt(j--))return false;
        }
        return true;
    }
}
