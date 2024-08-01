package day18;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
        System.out.println(tabulation(coins, amount));
    }

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int[] arr : dp)
            Arrays.fill(arr,-1);
        int res = memo(coins,n - 1,amount,dp);
        if(res == (int)(1e5))return -1;
        return res;
    }

    public static int memo(int[] coins,int index,int amount,int[][] dp){
        if(amount < 0)return (int)(1e5);
        if(amount == 0)return 0;
        if(index == 0){
            if(amount % coins[0] == 0)return amount / coins[0];
            else return (int)(1e5);
        }

        if(dp[index][amount] != -1)return dp[index][amount];

        int take = (int)(1e5), noTake = (int)(1e5);
        take = 1 + memo(coins,index ,amount - coins[index],dp);
        noTake = memo(coins,index - 1,amount,dp);

        return dp[index][amount] = Math.min(take, noTake);
    }
    public static int tabulation(int[] coins,int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for(int i = 0 ; i <= amount; i++){
            if(i % coins[0] == 0)dp[0][i] = i / coins[0];
            else dp[0][i] = 10000000;
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 0; j <= amount ; j++){
                int take = 10000000 , notake = 0;
                if(coins[i] <= j)
                    take = 1 + dp[i][j - coins[i]];
                notake = dp[i - 1][j];
                dp[i][j] = Math.min(take , notake);
            }
        }
        if(dp[n - 1][amount] >= 10000000)return -1;
        else return dp[n - 1][amount];
    }
}


