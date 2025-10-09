package Contests;

import java.util.Arrays;

public class biweekly_166 {
    public int climbStairs(int n, int[] costs) {
        return minCost(n,costs);
    }
    int minCost(int n, int[] arr){
        int dp[] = new int[n+1];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i =0;i<=n;i++){
            for(int j = 1;j<=3;j++){
                int nextS = i+j;
                if(nextS<=n){
                    int cost = arr[nextS-1]+j*j;
                    dp[nextS] = Math.min(dp[nextS],dp[i]+cost);
                }
            }
        }
        

        return dp[n];
    }
}
