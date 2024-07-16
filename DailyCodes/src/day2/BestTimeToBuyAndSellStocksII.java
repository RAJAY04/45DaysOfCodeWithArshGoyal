package day2;

import java.util.Arrays;

public class BestTimeToBuyAndSellStocksII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit1(prices));
    }

    //magical solution
    public static int maxProfit3(int[] prices) {
        int res = 0;
        int n = prices.length;

        for( int i = 1 ; i< n; i++){
            if(prices[i] >  prices[i-1]){
                res += (prices[i] - prices[i-1]);
            }
        }
        return res;
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] arr : dp)Arrays.fill(arr,-1);
        return memo(prices,0,0,dp);
    }
    public static int memo(int[] prices,int i,int bought ,int[][] dp){
        if(i >= prices.length)return 0;

        if(dp[i][bought] != -1)return dp[i][bought];

        int buy = 0, noBuy = 0 , sell = 0, noSell = 0;

        if(bought == 1){
            sell = memo(prices,i + 1,0,dp) + prices[i];
            noSell = memo(prices,i + 1,1 , dp);
        }else{
            buy = memo(prices,i + 1, 1,dp) - prices[i];
            noBuy = memo(prices, i + 1, 0,dp) ;
        }
        return dp[i][bought] = Math.max(Math.max(sell,noSell),Math.max(buy,noBuy));
    }

    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for(int i = n - 1; i >= 0 ; i--){
            for(int bought = 0 ; bought < 2; bought++) {
                int buy = 0, noBuy = 0, sell = 0, noSell = 0;
                if (bought == 1) {
                    sell = dp[i + 1][0] + prices[i];
                    noSell = dp[i + 1][bought];
                } else {
                    buy = dp[i + 1][1] - prices[i];
                    noBuy = dp[i + 1][bought];
                }
                dp[i][bought] = Math.max(Math.max(sell, noSell), Math.max(buy, noBuy));
            }
        }
        return dp[0][0];
    }

    public static int maxProfit2(int[] prices) {
        int n = prices.length;
        int[] curr = new int[2];
        int[] next = new int[2];

        for (int i = n - 1; i >= 0; i--) {
            for (int bought = 0; bought < 2; bought++) {
                int buy = 0, noBuy = 0, sell = 0, noSell = 0;
                if (bought == 1) {
                    sell = next[0] + prices[i];
                    noSell = next[1];
                } else {
                    buy = next[1] - prices[i];
                    noBuy = next[0];
                }
                curr[bought] = Math.max(Math.max(sell, noSell), Math.max(buy, noBuy));
            }
            int[] temp = next;
            next = curr;
            curr = temp;
        }
        return next[0];
    }

}
