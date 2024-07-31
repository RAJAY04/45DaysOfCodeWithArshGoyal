package day17;

public class CountingBits {
    public static void main(String[] args) {

    }

    public static int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i & (i - 1)] + 1;//i & i -1 drops the last set bit
        }
        return dp;
    }
}
