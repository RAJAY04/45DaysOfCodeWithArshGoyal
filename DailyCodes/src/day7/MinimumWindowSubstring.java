package day7;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "cabwefgewcwaefgcf";
        String t = "cae";
        System.out.println(minWindow(s,t));
    }

    public static String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()){
            return "";
        }

        int[] tFreq = new int[52];
        for(char c : t.toCharArray()){
            if(Character.isLowerCase(c))
                tFreq[c - 'a']++;
            else tFreq[c - 'A' + 26]++;
        }
        int n = s.length();
        StringBuilder res = new StringBuilder();
        int index = 0;
        while(index++ <= n){
            res.append('a');
        }
        int[] freq = new int[52];
        int i = 0 , j = 0;

        boolean flag = false;
        while(j < n){
            char c = s.charAt(j);

            if(Character.isLowerCase(c))
                freq[c - 'a']++;
            else freq[c - 'A' + 26]++;

            while(i < n && check(freq,tFreq)){
                char ch = s.charAt(i);
                if(Character.isLowerCase(ch))
                    freq[ch - 'a']--;
                else freq[ch - 'A' + 26]--;
                i++;
                if(j - i + 1 < res.length())flag = true;
            }
            if(flag){
                res.delete(0,res.length());
                res.append(s.substring(i - 1,j + 1));
                flag = false;
            }
            j++;
        }
        return res.toString();
    }

    public static boolean check(int[] sFreq , int[] tFreq){
        for(int i = 0 ; i < 52; i++){
            if(sFreq[i]  < tFreq[i])return false;
        }
        return true;
    }
}
