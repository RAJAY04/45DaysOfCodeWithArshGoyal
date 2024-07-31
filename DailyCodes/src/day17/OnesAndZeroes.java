package day17;

import java.util.Arrays;

public class OnesAndZeroes {
    public static void main(String[] args) {
        String[] strs = {"111","1000","1000","1000"};
        int m = 9;
        int n = 3;
        System.out.println(findMaxForm(strs, m, n));
        System.out.println(tabulation(strs, m, n));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] helper = new int[strs.length][2];
        int len = strs.length;
        for(int i = 0 ; i < len; i++){
            int z = 0 , o = 0;
            for(char c : strs[i].toCharArray()){
                if(c == '0')z++;
                else o++;
            }
            helper[i][0] = z;
            helper[i][1] = o;
        }
        int[][][] dp = new int[len][m + 1][n + 1];
        for(int[][] sub : dp){
            for(int[] subsub : sub){
                Arrays.fill(subsub,-1);
            }
        }
        return memo(strs,0,helper,m,n,dp);
    }

    public static int memo(String[] strs,int idx,int[][] helper,int m ,int n,int[][][] dp){
        if(idx == strs.length || (m <= 0 && n <= 0))return 0;

        if(dp[idx][m][n] != -1)return dp[idx][m][n];
        int take = 0 , noTake = 0;
        String s = strs[idx];
        int ones = helper[idx][1],zeros = helper[idx][0];
        if(m - zeros >= 0 && n - ones >= 0)
            take = 1 + memo(strs,idx + 1,helper,m - zeros, n - ones,dp);
        noTake = memo(strs,idx + 1, helper, m ,n,dp);

        return dp[idx][m][n] = Math.max(take,noTake);
    }

    public static int tabulation(String[] strs, int m, int n){
        int[][] helper = new int[strs.length][2];
        int len = strs.length;
        for(int i = 0 ; i < len; i++){
            int z = 0 , o = 0;
            for(char c : strs[i].toCharArray()){
                if(c == '0')z++;
                else o++;
            }
            helper[i][0] = z;
            helper[i][1] = o;
        }
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        for(int idx = len - 1; idx >= 0; idx--) {
            int zeros = helper[idx][0];
            int ones = helper[idx][1];
            for(int i = 0; i <= m; i++) {
                for(int j = 0; j <= n; j++) {
                    int take = 0, noTake = 0;
                    if(i - zeros >= 0 && j - ones >= 0) {
                        take = 1 + dp[idx + 1][i - zeros][j - ones];
                    }
                    noTake = dp[idx + 1][i][j];
                    dp[idx][i][j] = Math.max(take, noTake);
                }
            }
        }
        return dp[0][m][n];
    }
}
