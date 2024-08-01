package day18;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 1;
        for(int i = 0 ; i < n ;i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[prev] < nums[i] && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] + 1;
                    max = Math.max(dp[i],max);
                }
            }
        }
        return max;
    }
}
