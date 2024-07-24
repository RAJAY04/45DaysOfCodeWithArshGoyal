package day10;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
        System.out.println(ladderLength1(beginWord, endWord, wordList));
    }

    static class Pair{
        String s ;
        int level ;
        Pair(String s, int level){
            this.s = s;
            this.level = level;
        }
    }
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for(String s : wordList)dict.add(s);
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(beginWord,1));

        while(!queue.isEmpty()){
            String s = queue.peek().s;
            int level = queue.peek().level;
            if(s.equals(endWord))return level;

            char[] str = s.toCharArray();
            for(int i = 0 ; i < str.length; i++){
                char cur = str[i];
                for(char c = 'a'; c <= 'z'; c++){
                    str[i] = c;
                    String newString = new String(str);
                    if(dict.contains(newString)){
                        queue.add(new Pair(newString,level + 1));
                        dict.remove(newString);
                    }
                }
                str[i] = cur;
            }
            queue.poll();
        }
        return 0;
    }

    public static int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                if (s.equals(endWord)) return level;

                char[] str = s.toCharArray();
                for (int j = 0; j < str.length; j++) {
                    char cur = str[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (cur == c) continue; // Skip same character replacement
                        str[j] = c;
                        String newString = new String(str);
                        if (dict.contains(newString)) {
                            queue.add(newString);
                            dict.remove(newString);
                        }
                    }
                    str[j] = cur;
                }
            }
            level++;
        }
        return 0;
    }
}
