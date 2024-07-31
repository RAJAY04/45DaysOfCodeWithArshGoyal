package day17;

import java.util.Arrays;

public class KinightDialer {
    public static void main(String[] args) {
        System.out.println(knightDialer(1));
    }
    public static int knightDialer(int n) {
        int MOD = 1_000_000_007;
        int[][][] dp = new int[n + 1][4][3];
        for (int[][] arr2D : dp) {
            for (int[] arr : arr2D) {
                Arrays.fill(arr, -1);
            }
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 3 && (j == 0 || j == 2)) continue;
                count = (count + memo(dp, i, j, n, MOD)) % MOD;
            }
        }
        return count;
    }

    public static int memo(int[][][] dp, int r, int c, int n, int MOD) {
        if (r < 0 || r >= 4 || c < 0 || c >= 3 || (r == 3 && (c == 0 || c == 2))) return 0;
        if (n == 1) return 1;
        if (dp[n][r][c] != -1) return dp[n][r][c];

        int count = 0;
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int k = 0; k < 8; k++) {
            int x = r + dx[k];
            int y = c + dy[k];
            count = (count + memo(dp, x, y, n - 1, MOD)) % MOD;
        }

        dp[n][r][c] = count;
        return count;
    }
}
