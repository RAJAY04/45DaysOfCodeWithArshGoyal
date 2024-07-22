package day8;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < strs.length; i++){
            min = Math.min(min,strs[i].length());
        }
        for(int i = 0 ; i < min; i++){
            char c = strs[0].charAt(i);
            for(int j = 0 ; j < strs.length; j++){
                if(c != strs[j].charAt(i))return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0, min);
    }
    public String longestCommonPrefix1(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
