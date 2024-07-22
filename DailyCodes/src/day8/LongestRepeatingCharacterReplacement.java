package day8;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "ABAB";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }

    public static int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        int n = s.length();
        int[] charCount = new int[26];
        int maxCount = 0;
        int res = 0;

        while (j < n) {
            charCount[s.charAt(j) - 'A']++;
            maxCount = Math.max(maxCount, charCount[s.charAt(j) - 'A']);
            //no need to reset maxcount because we already have our longest ans with particular maxCount
            while ((j - i + 1) - maxCount > k) {//if also can be used
                charCount[s.charAt(i) - 'A']--;
                i++;
            }

            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
