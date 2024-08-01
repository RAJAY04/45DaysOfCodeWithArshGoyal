package day18;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "135181825389192013119";
        System.out.println(numDecodings(s));
        System.out.println(tabulation(s));
    }

    public static int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        return memo(s, 0, dp);
    }

    public static int memo(String s, int index, int[] dp) {
        if (index == s.length()) return 1;

        if (s.charAt(index) == '0') return 0;

        if (dp[index] != -1) return dp[index];

        int res = memo(s, index + 1, dp);

        if (index < s.length() - 1) {
            int num = Integer.parseInt(s.substring(index, index + 2));
            if (num >= 10 && num <= 26) {
                res += memo(s, index + 2, dp);
            }
        }

        return dp[index] = res;
    }

    public static int tabulation(String s){
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for(int i = s.length() - 1; i >= 0 ; i--){
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
            }

                if (i < s.length() - 1) {
                int num = Integer.parseInt(s.substring(i, i + 2));
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }
}
