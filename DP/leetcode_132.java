package DP;

import java.util.Arrays;

public class leetcode_132 {
    int[][] dp;
    boolean[][] isPal;

    public int minCut(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        isPal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                }
            }
        }

        return minCutt(s, 0, s.length() - 1);
    }

    int minCutt(String s, int i, int j) {
        if (i >= j || isPal[i][j]) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            if(isPal[i][k]){
                int r = minCutt(s,k+1,j);
                min = Math.min(min, r+1);
            }

        }

        return dp[i][j] = min;
    }
}
