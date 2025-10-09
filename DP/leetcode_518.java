package DP;

public class leetcode_518 {
    int[][]dp;
    public int change(int amount, int[] coins) {
        int n = coins.length;
        dp = new int[n+1][amount+1];

        return totalWays(coins,amount);
    }

    int totalWays(int[] coins,int amo){
        int n = coins.length;

        //Initialization
        for(int i = 0;i<=n;i++){
            dp[i][0]= 1;
        }

        //Core logic
        for(int i = 1;i<=n;i++){
            for(int j = 0;j<=amo;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][amo];
    }
}
