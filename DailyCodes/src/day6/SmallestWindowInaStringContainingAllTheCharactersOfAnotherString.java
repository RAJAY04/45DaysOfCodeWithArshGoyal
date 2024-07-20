package day6;

public class SmallestWindowInaStringContainingAllTheCharactersOfAnotherString {
    public static void main(String[] args) {
        String s = "mpsbqedzsqyskjqydomdanqfmtqri";
        String t = "rrbqrnbbzyijnwfnimshbjimbfe";
        System.out.println(smallestWindow(s, t));
    }

    public static String smallestWindow(String s, String p)
    {
        int n = s.length();
        int[][] preSum = new int[n][26];
        preSum[0][s.charAt(0) - 'a']++;
        for(int i = 1 ; i < n ; i++){
            preSum[i][s.charAt(i) - 'a']++;
            for(int j = 0 ; j < 26 ; j++){
                preSum[i][j] += preSum[i - 1][j];
            }
        }

        int[] pFreq = new int[26];
        for(char c : p.toCharArray()){
            pFreq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() + 1; i++)sb.append("1");
        String temp = sb.toString();

        boolean flag = false;
        int i = 0 , j = 1;
        while(j < n){
            while(i < n && calculateFreq(s,preSum,pFreq,i,j)){
                i++;
                flag = true;
            }
            if(flag){
                if(sb.length() - 1 > (j - i + 1)){
                    sb = new StringBuilder();
                    sb.append(s.substring(i - 1,j + 1));
                }

                flag = false;
            }
            j++;
        }
        return sb.toString().equals(temp)?"-1":sb.toString();
    }
    public static boolean calculateFreq(String s ,int[][] preSum , int[] pFreq , int i , int j ){
        for(int k = 0 ; k < 26; k++){
            int freq = preSum[j][k] - ((i > 0)? preSum[i - 1][k] : 0);
            if(pFreq[k] > freq)return false;
        }
        return true;
    }


    public static String smallestWindow1(String s, String p)
    {

        int len1 = s.length();
        int len2 = p.length();

        //if length of string p is greater than string s then we return -1.
        if(len1 < len2){
            return "-1";
        }

        //using hash tables to store the count of characters in strings.
        int[] hash_pat = new int[256];
        int[] hash_str = new int[256];

        //storing the count of characters in string p in hash table.
        for(int i = 0; i < len2; i++){
            hash_pat[p.charAt(i)]++;
        }

        int start = 0;
        int start_index = -1;
        int min_len = Integer.MAX_VALUE;
        int count = 0;
        for(int j = 0; j < len1; j++)
        {
            //storing the count of characters in string s in hash table.
            hash_str[s.charAt(j)]++;

            //if count of current character in string s is equal to or less
            //than in string p, we increment the counter.
            if(hash_pat[s.charAt(j)] != 0
                    &&hash_str[s.charAt(j)] <= hash_pat[s.charAt(j)])
            {
                count++;
            }

            //if all the characters are matched
            if(count == len2)
            {
                while(hash_str[s.charAt(start)]>hash_pat[s.charAt(start)] ||
                        hash_pat[s.charAt(start)] == 0)
                {
                    //we try to minimize the window.
                    if(hash_str[s.charAt(start)]>hash_pat[s.charAt(start)])
                    {
                        hash_str[s.charAt(start)]--;
                    }
                    start++;
                }
                //updating window size.
                int len_window = j - start + 1;
                if(min_len > len_window)
                {
                    //if new minimum sub-string is found, we store value
                    //of its starting index for new found window.
                    min_len = len_window;
                    start_index = start;
                }
            }

        }
        //returning the smallest window or -1 if no such window is present.
        if(start_index == -1){
            return("-1");
        }
        else{
            return(s.substring(start_index, start_index + min_len));
        }
    }
}
