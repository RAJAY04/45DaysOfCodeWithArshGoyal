package day18;

import java.util.Arrays;

public class MaximiseCutSegments {
    public static void main(String[] args) {
        System.out.println(maximizeCuts(7, 5, 5, 2));
        System.out.println(tabulation(7, 5, 5, 2));
    }

    public static int maximizeCuts(int n, int x, int y, int z)
    {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        int res =  memo(n,x,y,z,dp);
        return (res < 0) ? 0 : res;
    }
    public static int memo(int n ,int x ,int y,int z,int[] dp){
        if(n < 0)return Integer.MIN_VALUE;
        if(n == 0)return 0;

        if(dp[n] != -1)return dp[n];
        int opn1 = 0 , opn2 = 0 , opn3 = 0;
        opn1 = memo(n - x, x, y, z, dp) + 1;
        opn2 = memo(n - y, x, y, z, dp) + 1;
        opn3 = memo(n - z, x, y, z, dp) + 1;
        return dp[n] = Math.max(opn1,Math.max(opn2,opn3));
    }

    public static int tabulation(int n ,int x,int y,int z){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE); // Initialize the array to represent uninitialized states.
        dp[0] = 0; // Base case: 0 length needs 0 cuts.

        for (int i = 1; i <= n; i++) {
            if (i - x >= 0 && dp[i - x] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if (i - y >= 0 && dp[i - y] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if (i - z >= 0 && dp[i - z] != Integer.MIN_VALUE) {
                dp[i] = Math.max(dp[i], dp[i - z] + 1);
            }
        }

        return dp[n] == Integer.MIN_VALUE ? 0 : dp[n];
    }
}
