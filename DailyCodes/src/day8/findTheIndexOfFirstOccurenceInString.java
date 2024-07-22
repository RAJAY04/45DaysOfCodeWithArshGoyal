package day8;

public class findTheIndexOfFirstOccurenceInString {
    public static void main(String[] args) {
        String haystack = "hello", needle = "ll";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        int i = 0 ,j = 0;
        int n = haystack.length(), m = needle.length();
        while(i < n){
            if(haystack.charAt(i) == needle.charAt(j)){
                int index = i;
                while((j < m && index < n) && haystack.charAt(index) == needle.charAt(j)){
                    index++;j++;
                }
                if(j == m)return i;
                else{
                    j = 0;
                }
            }
            i++;

        }
        return -1;
    }
}
