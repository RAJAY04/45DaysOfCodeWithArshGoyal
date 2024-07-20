package day6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] freq = new char[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }
            String hash = new String(freq);
            if(map.containsKey(hash)){
                List<String> temp = map.get(hash);
                temp.add(s);
                map.put(hash,temp);
            }else{
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(hash,temp);
            }
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;

    }
}
