package day2;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int sell  = 0 , maxProfit = 0;
        for(int i = 1 ; i < prices.length ;i++){
            maxProfit = Math.max(prices[i] - buy,maxProfit);
            buy = Math.min(buy,prices[i]);
        }
        return maxProfit;
    }
}
