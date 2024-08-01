package day18;

import java.util.Arrays;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
        System.out.println(tabulation(grid));
    }
    public static int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr :dp) Arrays.fill(arr, -1);
        return memo(grid,n - 1, m - 1, dp);
    }
    public static int memo(int[][] grid,int r, int c,int[][] dp){
        if(r == 0 && c == 0)return grid[0][0];

        if(dp[r][c] != -1)return dp[r][c];

        int opn1 = Integer.MAX_VALUE, opn2 = Integer.MAX_VALUE;
        if(r - 1 >= 0)
            opn1 = grid[r][c] + memo(grid,r - 1,c,dp);
        if(c - 1 >= 0)
            opn2 = grid[r][c] + memo(grid,r, c - 1,dp);

        return dp[r][c] = Math.min(opn1,opn2);
    }

    public static int tabulation(int[][] grid){
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j] , dp[i][j - 1]);
            }
        }
        return dp[n - 1][m - 1];
    }

}
