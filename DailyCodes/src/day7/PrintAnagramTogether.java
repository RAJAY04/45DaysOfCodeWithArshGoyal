package day7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintAnagramTogether {
    public static void main(String[] args) {
        String[] string_list = {"act","god","cat","dog","tac"};
        System.out.println(Anagrams(string_list));
    }
    public static List<List<String>> Anagrams(String[] string_list) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s : string_list){
            char[] freq = new char[26];
            for(char c : s.toCharArray()){
                freq[c - 'a']++;
            }
            String hash = new String(freq);

            if(!map.containsKey(hash)){
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(hash,temp);
            }else{
                List<String> temp = map.get(hash);
                temp.add(s);
                map.put(hash,temp);
            }
        }
        List<List<String>> res = new ArrayList<>(map.values());
        return res;
    }
}
