package DP;

import java.util.Arrays;

public class leetcode_887 {
    int [][]dp;
    public int superEggDrop(int k, int n) {
        dp = new int[k+1][n+1];
        for(int []arr : dp){
            Arrays.fill(arr,-1);
        }
        return minMove(k,n);
    }

    int minMove(int k, int n){
        if(k==1 || n==1||n==0){
            return dp[k][n] = n;
        }

        if(dp[k][n] != -1){
            return dp[k][n];
        }

        int l = 1,h=n;
        int min = Integer.MAX_VALUE;

        while(l<=h){
            int m = l + (h-l)/2;

            int down = dp[k-1][m-1] != -1?dp[k-1][m-1]:minMove(k-1,m-1);
            int up = dp[k][n-m] != -1?dp[k][n-m]:minMove(k,n-m);

            int temp = 1 + Math.max(down,up);
            min = Math.min(temp,min);

            if(down<up){
                l = m+1;
            }else{
                h = m-1;
            }
        }

        return dp[k][n] = min;
    }
}
